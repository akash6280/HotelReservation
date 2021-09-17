package com.bridgelabz.hotelreservation;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.bridgelabz.hotelreservation.HotelReservationException.exceptionType;

public class HotelReservation {
	List<Hotel> hotelList=new ArrayList<>();
	int noOfWeekDay=0;
	int noOfWeekEnd=0;
	
	public boolean addHotel(Hotel hotel) {
		hotelList.add(hotel);
		return true;
	}
	
	public Hotel cheapestHotel(LocalDate arrivalDate,LocalDate departureDate,CustomerType customerType) {
		
		while(arrivalDate.compareTo(departureDate) <=0) {
			if(arrivalDate.getDayOfWeek()==DayOfWeek.SATURDAY||arrivalDate.getDayOfWeek()==DayOfWeek.SUNDAY)
				noOfWeekEnd++;
			else
				noOfWeekDay++;
			arrivalDate=arrivalDate.plusDays(1);
		}
		if(customerType==CustomerType.REGULAR) {
			Hotel cheapestHotel = hotelList.stream()
						    	  .min((h1,h2)-> (h1.getWeekendHotelRate()*noOfWeekEnd+h1.getWeekdayHotelRate()*noOfWeekDay)-(h2.getWeekendHotelRate()*noOfWeekEnd+h2.getWeekdayHotelRate()*noOfWeekDay))
							      .orElse(null);
	    	return cheapestHotel;
		}
		else {
			Hotel cheapestHotel = hotelList.stream()
								  .min((h1,h2)-> (h1.getRewardWeekEndHotelRate()*noOfWeekEnd+h1.getRewardWeekDayHotelRate()*noOfWeekDay)-(h2.getRewardWeekEndHotelRate()*noOfWeekEnd+h2.getRewardWeekDayHotelRate()*noOfWeekDay))
								  .orElse(null);
			return cheapestHotel;
		}
			
		
	}
	
	public Hotel cheapestAndBestRatedHotel(LocalDate arrivalDate,LocalDate departureDate,CustomerType customerType) {
		try {	
				if(arrivalDate.isAfter(departureDate))
					throw new HotelReservationException(exceptionType.ENTERED_INVALID,"Entered wrong range of date");
				
				Hotel cheapestHotel=cheapestHotel(arrivalDate, departureDate,customerType);
				if(customerType==CustomerType.REGULAR) {
					Hotel cheapestBestRatedHotel=hotelList.stream()
												 .filter(h->(h.getWeekendHotelRate()*noOfWeekEnd+h.getWeekdayHotelRate()*noOfWeekDay)==(cheapestHotel.getWeekdayHotelRate()*noOfWeekDay+cheapestHotel.getWeekendHotelRate()*noOfWeekEnd))
									       	     .max((h1,h2) -> h1.getHotelRating()-h2.getHotelRating())
										         .orElse(null);
					return cheapestBestRatedHotel;
				}
				else {
					Hotel cheapestBestRatedHotel=hotelList.stream()
						                    	 .filter(h->(h.getRewardWeekDayHotelRate()*noOfWeekEnd+h.getRewardWeekEndHotelRate()*noOfWeekDay)==(cheapestHotel.getRewardWeekDayHotelRate()*noOfWeekDay+cheapestHotel.getRewardWeekEndHotelRate()*noOfWeekEnd))
				       	                         .max((h1,h2) -> h1.getHotelRating()-h2.getHotelRating())
					                             .orElse(null);
					return cheapestBestRatedHotel;
					
				}
					
		} 
		catch (NullPointerException e) {
			throw new HotelReservationException(exceptionType.ENTERED_NULL,"entered Null value");
		}
	}
	public Hotel getBestRatedHotel(LocalDate arrivalDate,LocalDate departureDate) {
		
		while(arrivalDate.compareTo(departureDate) <=0) {
			if(arrivalDate.getDayOfWeek()==DayOfWeek.SATURDAY||arrivalDate.getDayOfWeek()==DayOfWeek.SUNDAY)
				noOfWeekEnd++;
			else
				noOfWeekDay++;
			arrivalDate=arrivalDate.plusDays(1);
		}
		Hotel bestRatedHotel = hotelList.stream()
							  .max( (h1,h2)->h1.getHotelRating()-h2.getHotelRating())
							  .orElse(null);
		if(bestRatedHotel!=null)	
		System.out.println("Price"+(bestRatedHotel.getWeekdayHotelRate()*noOfWeekDay+bestRatedHotel.getWeekendHotelRate()*noOfWeekEnd));
		return bestRatedHotel;
		
	}
}