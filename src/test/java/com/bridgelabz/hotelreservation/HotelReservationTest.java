package com.bridgelabz.hotelreservation;

import org.junit.Test;

import com.bridgelabz.hotelreservation.HotelReservationException.exceptionType;

import java.time.LocalDate;
import org.junit.Assert;

public class HotelReservationTest {
	@Test
	public void givenHotel_WhenAdded_ShouldReturnTrue() {
		Hotel hotel=new Hotel("LakeWood",110,150,3,80,80);
		HotelReservation hotelReservation=new HotelReservation();
		boolean result=hotelReservation.addHotel(hotel);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenDate_WhenFoundCheapestHotel_ShouldReturnHotel() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",150, 50,4,110,50);
		hotelReservation.addHotel(hotel2);
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 11);
		
		Hotel hotel=hotelReservation.cheapestHotel(arrivalDate, departureDate,CustomerType.REGULAR);
		Assert.assertEquals("LakeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenWeekendAndWeekDays_WhenFoundCheapestHotel_ShouldReturnHotel() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",150, 50,4,110,50);
		hotelReservation.addHotel(hotel2);
		Hotel hotel3=new Hotel("RidgeWood",220, 150,5,100,40);
		hotelReservation.addHotel(hotel3);
		
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 15);
		
		Hotel hotel=hotelReservation.cheapestHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertEquals("LakeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenWeekendAndWeekDays_WhenNoHotel_ShouldReturnNull() {
		HotelReservation hotelReservation=new HotelReservation();
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 15);
		
		Hotel hotel=hotelReservation.cheapestHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertNull(hotel);
	}
	
	@Test
	public void givenDateRange_WhenFoundCheapestAndBestRatedHotel_ShouldReturnHotel() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",110, 90,4,110,50);
		hotelReservation.addHotel(hotel2);
		Hotel hotel3=new Hotel("RidgeWood",220, 150,5,100,40);
		hotelReservation.addHotel(hotel3);
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 15);
		Hotel hotel=hotelReservation.cheapestAndBestRatedHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertEquals("LakeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenDateRange_WhenNotFoundCheapestAndBestRatedHotel_ShouldReturnNull() {
		HotelReservation hotelReservation=new HotelReservation();
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 15);
		Hotel hotel=hotelReservation.cheapestAndBestRatedHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertEquals(null,hotel);
	}
	
	@Test
	public void givenDateRange_WhenFoundBestRatedHotel_ShouldReturnHotel() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",150, 50,4,110,50);
		hotelReservation.addHotel(hotel2);
		Hotel hotel3=new Hotel("RidgeWood",220, 150,5,100,40);
		hotelReservation.addHotel(hotel3);
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 15);
		Hotel hotel=hotelReservation.getBestRatedHotel(arrivalDate, departureDate);
		Assert.assertEquals("RidgeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenDateRange_WhenNoBestRatedHotelFound_ShouldReturnNull() {
		HotelReservation hotelReservation=new HotelReservation();
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		LocalDate departureDate = LocalDate.of(2020, 9, 15);
		Hotel hotel=hotelReservation.getBestRatedHotel(arrivalDate, departureDate);
		Assert.assertNull(hotel);
	}
	
	@Test
	public void givenDateRange_WhenArrivaLDateIsNull_ShouldThrowException() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",150, 50,4,110,50);
		hotelReservation.addHotel(hotel2);
		Hotel hotel3=new Hotel("RidgeWood",220, 150,5,100,40);
		hotelReservation.addHotel(hotel3);
		LocalDate departureDate = LocalDate.of(2020, 9, 15);
		
		try {
			hotelReservation.cheapestAndBestRatedHotel(null, departureDate,CustomerType.REWARD);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_NULL,e.etype);
		}
	}
	
	@Test
	public void givenDateRange_WhenDepartureDateIsNull_ShouldThrowException() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",150, 50,4,110,50);
		hotelReservation.addHotel(hotel2);
		Hotel hotel3=new Hotel("RidgeWood",220, 150,5,100,40);
		hotelReservation.addHotel(hotel3);
		LocalDate arrivalDate = LocalDate.of(2020, 9, 10);
		
		try {
			hotelReservation.cheapestAndBestRatedHotel(arrivalDate,null,CustomerType.REWARD);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_NULL,e.etype);
		}
	}
	
	@Test
	public void givenDateRange_WhenArrivalDateIsAfterDepartureDate_ShouldThrowException() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",150, 50,4,110,50);
		hotelReservation.addHotel(hotel2);
		Hotel hotel3=new Hotel("RidgeWood",220, 150,5,100,40);
		hotelReservation.addHotel(hotel3);
		LocalDate arrivalDate = LocalDate.of(2020, 9, 15);
		LocalDate departureDate = LocalDate.of(2020, 9, 10);
		try {
			hotelReservation.cheapestAndBestRatedHotel(arrivalDate,departureDate,CustomerType.REWARD);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_INVALID,e.etype);		
		}
	}
  
}