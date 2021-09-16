package com.bridgelabz.hotelreservation;

import org.junit.Test;
import org.junit.Assert;

public class HotelReservationTest {
	@Test
	public void givenHotel_WhenAdded_ShouldReturnTrue() {
		Hotel hotel=new Hotel("Lakewood",100);
		HotelReservation hotelReservation=new HotelReservation();
		boolean result=hotelReservation.addHotel(hotel);
		Assert.assertTrue(result);
	}
  
}