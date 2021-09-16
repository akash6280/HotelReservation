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
		Hotel hotel=hotelList.stream().min((c1,c2)->c1.getHotelRate()-c2.getHotelRate()).orElse(null);
		if(hotel==null)
			System.out.println("No Cheapest Hotel");
		else
			System.out.println("Cheapest hotel"+hotel.getHotelRate()*stayPeriod);
		return hotel;
		
	}
}