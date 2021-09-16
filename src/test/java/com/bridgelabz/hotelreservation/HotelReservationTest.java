package com.bridgelabz.hotelreservation;

import org.junit.Test;
import java.time.LocalDate;
import org.junit.Assert;

public class HotelReservationTest {
	@Test
	public void givenHotel_WhenAdded_ShouldReturnTrue() {
		Hotel hotel=new Hotel("Lakewood",100);
		HotelReservation hotelReservation=new HotelReservation();
		boolean result=hotelReservation.addHotel(hotel);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenDate_WhenFoundCheapestHotel_ShouldReturnHotel() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("Lakewood",100);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",200);
		hotelReservation.addHotel(hotel2);
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 11);
		
		Hotel hotel=hotelReservation.cheapestHotel(arrivalDate, departureDate);
		Assert.assertEquals("Lakewood",hotel.getHotelName());
	}
  
}