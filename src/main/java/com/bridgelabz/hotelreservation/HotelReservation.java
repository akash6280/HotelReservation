package com.bridgelabz.hotelreservation;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	List<Hotel> hotelList=new ArrayList<>();
	int noOfWeekDay=0;
	int noOfWeekEnd=0;
	public boolean addHotel(Hotel hotel) {
		hotelList.add(hotel);
		return true;
	}
	
	public Hotel cheapestHotel(LocalDate arrivalDate,LocalDate departureDate) {
		
		while(arrivalDate.compareTo(departureDate) <=0) {
			if(arrivalDate.getDayOfWeek()==DayOfWeek.SATURDAY||arrivalDate.getDayOfWeek()==DayOfWeek.SUNDAY)
				noOfWeekEnd++;
			else
				noOfWeekDay++;
			arrivalDate=arrivalDate.plusDays(1);
		}
		Hotel cheapestHotel = hotelList.stream()
							  .min((h1,h2)-> (h1.getWeekendHotelRate()*noOfWeekEnd+h1.getWeekdayHotelRate()*noOfWeekDay)-(h2.getWeekendHotelRate()*noOfWeekEnd+h2.getWeekdayHotelRate()*noOfWeekDay))
							  .orElse(null);
		return cheapestHotel;
		
	}
}