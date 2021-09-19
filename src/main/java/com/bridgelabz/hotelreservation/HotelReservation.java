package com.bridgelabz.hotelreservation;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import com.bridgelabz.hotelreservation.HotelReservationException.exceptionType;

public class HotelReservation implements HotelReservationIF {
	List<Hotel> hotelList=new ArrayList<>();
	int noOfWeekDay=0;
	int noOfWeekEnd=0;
	
	public boolean addHotel(Hotel hotel) {
		hotelList.add(hotel);
		return true;
	}
	
	public Hotel cheapestHotel(LocalDate arrivalDate,LocalDate departureDate,CustomerType customerType) {
		
		DateServiceProvider services= new DateServiceProvider();
		noOfWeekEnd=services.getNumOfWeekEnd(arrivalDate, departureDate);
		noOfWeekDay=services.getNumOfWeekDay(arrivalDate, departureDate);
		
		if(customerType==CustomerType.REGULAR) {
			Hotel cheapestHotel = hotelList.stream()
						    	  .min((h1,h2)-> getTotalPriceForRegularCustomer(h1,noOfWeekDay,noOfWeekEnd)-getTotalPriceForRegularCustomer(h2,noOfWeekDay,noOfWeekEnd))
							      .orElse(null);
	    	return cheapestHotel;
		}
		else {
			Hotel cheapestHotel = hotelList.stream()
								  .min((h1,h2)-> getTotalPriceForRewardedCustomer(h1,noOfWeekDay,noOfWeekEnd)-getTotalPriceForRewardedCustomer(h2,noOfWeekDay,noOfWeekEnd))
								  .orElse(null);
			return cheapestHotel;
		}
			
		
	}
	
	public Hotel cheapestAndBestRatedHotel(LocalDate arrivalDate,LocalDate departureDate,CustomerType customerType) {
		try {	
				
				validateDate(arrivalDate.toString(),departureDate.toString());
				DateServiceProvider services= new DateServiceProvider();
				noOfWeekEnd=services.getNumOfWeekEnd(arrivalDate, departureDate);
				noOfWeekDay=services.getNumOfWeekDay(arrivalDate, departureDate);
				
				Hotel cheapestHotel=cheapestHotel(arrivalDate, departureDate,customerType);
				if(customerType==CustomerType.REGULAR) {
					Hotel cheapestBestRatedHotel=hotelList.stream()
												 .filter(h->getTotalPriceForRegularCustomer(h,noOfWeekDay,noOfWeekEnd)==getTotalPriceForRegularCustomer(cheapestHotel,noOfWeekDay,noOfWeekEnd))
									       	     .max((h1,h2) -> h1.getHotelRating()-h2.getHotelRating())
										         .orElse(null);
					return cheapestBestRatedHotel;
				}
				else {
					Hotel cheapestBestRatedHotel=hotelList.stream()
						                    	 .filter(h->getTotalPriceForRewardedCustomer(h,noOfWeekDay,noOfWeekEnd)==getTotalPriceForRewardedCustomer(cheapestHotel,noOfWeekDay,noOfWeekEnd))
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
		
		DateServiceProvider services= new DateServiceProvider();
		noOfWeekEnd=services.getNumOfWeekEnd(arrivalDate, departureDate);
		noOfWeekDay=services.getNumOfWeekDay(arrivalDate, departureDate);
		
		Hotel bestRatedHotel = hotelList.stream()
							  .max( (h1,h2)->h1.getHotelRating()-h2.getHotelRating())
							  .orElse(null);
		
		if(bestRatedHotel!=null)	
		System.out.println("Price"+(bestRatedHotel.getWeekdayHotelRate()*noOfWeekDay+bestRatedHotel.getWeekendHotelRate()*noOfWeekEnd));
		return bestRatedHotel;
		
	}
	
	public int getTotalPriceForRegularCustomer(Hotel hotel,int noOfWeekDay,int noOfWeekEnd) {
		
		return hotel.getWeekdayHotelRate()*noOfWeekDay+hotel.getWeekendHotelRate()*noOfWeekEnd;
	}
	
	public int getTotalPriceForRewardedCustomer(Hotel hotel,int noOfWeekDay,int noOfWeekEnd) {
		
		return hotel.getRewardWeekDayHotelRate()*noOfWeekDay+hotel.getRewardWeekEndHotelRate()*noOfWeekEnd;
	}
	
	public  boolean validateDate(String date1,String date2) {
		try {
			String dateRegex="^([0-9]{4})[-]((0[1-9])|1[012])[-]([012][0-9]|[3][01])$";
			if(Pattern.matches(dateRegex, date1)&& Pattern.matches(dateRegex, date2) )
				return true;
			else if(date1.length()==0||date2.length()==0)
				throw new HotelReservationException(exceptionType.ENTERED_EMPTY,"Entered empty value");
			else
				throw new HotelReservationException(exceptionType.ENTERED_INVALID,"Entered invalid date");
		}catch(NullPointerException e) {
			throw new HotelReservationException(exceptionType.ENTERED_NULL,"enterd null value"); 
		}

	}
}