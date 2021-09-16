package com.bridgelabz.hotelreservation;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	List<Hotel> hotelList=new ArrayList<>();
	
	public boolean addHotel(Hotel hotel) {
		hotelList.add(hotel);
		return true;
	}
	
	public Hotel cheapestHotel(LocalDate arrivalDate,LocalDate departureDate) {
	
		int stayPeriod = Period.between(arrivalDate, departureDate).getDays();
		Hotel hotel=hotelList.stream().min((c1,c2)->c1.getWeekdayHotelRate()-c2.getWeekdayHotelRate()).orElse(null);
		System.out.println("Cheapest hotel"+hotel.getWeekdayHotelRate()*stayPeriod);
		return hotel;
		
	}
}