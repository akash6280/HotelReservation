package com.bridgelabz.hotelreservation;
import java.util.LinkedList;
import java.util.List;

public class HotelReservation {
	List<Hotel> hotelList=new LinkedList<>();
	
	public boolean addHotel(Hotel hotel) {
		hotelList.add(hotel);
		return true;
	}
}