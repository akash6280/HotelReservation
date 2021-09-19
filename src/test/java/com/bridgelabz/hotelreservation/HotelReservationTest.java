package com.bridgelabz.hotelreservation;

import org.junit.Test;

import com.bridgelabz.hotelreservation.HotelReservationException.exceptionType;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;

public class HotelReservationTest {
	LocalDate arrivalDate;
	LocalDate departureDate;
	HotelReservation hotelReservation;
	
	@Before
	public void initialise() {
		hotelReservation=new HotelReservation();
		Hotel hotel1=new Hotel("LakeWood",110, 90,3,80,80);
		hotelReservation.addHotel(hotel1);
		Hotel hotel2=new Hotel("BridgeWood",150, 50,4,110,50);
		hotelReservation.addHotel(hotel2);
		Hotel hotel3=new Hotel("LakeWood",220, 150,5,100,40);
		hotelReservation.addHotel(hotel3);
		arrivalDate = LocalDate.of(2020, 9, 10);
	    departureDate = LocalDate.of(2020, 9, 11);
	}
	
	@Test
	public void givenHotel_WhenAdded_ShouldReturnTrue() {
		Hotel hotel=new Hotel("LakeWood",110,150,3,80,80);
		boolean result=hotelReservation.addHotel(hotel);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenDate_WhenFoundCheapestHotel_ShouldReturnHotel() {
		
		Hotel hotel=hotelReservation.cheapestHotel(arrivalDate, departureDate,CustomerType.REGULAR);
		Assert.assertEquals("LakeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenWeekendAndWeekDays_WhenFoundCheapestHotel_ShouldReturnHotel() {

		Hotel hotel=hotelReservation.cheapestHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertEquals("LakeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenWeekendAndWeekDays_WhenNoHotel_ShouldReturnNull() {
		HotelReservation hotelReservation=new HotelReservation();
		
		Hotel hotel=hotelReservation.cheapestHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertNull(hotel);
	}
	
	@Test
	public void givenDateRange_WhenFoundCheapestAndBestRatedHotel_ShouldReturnHotel() {
		
		Hotel hotel=hotelReservation.cheapestAndBestRatedHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertEquals("LakeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenDateRange_WhenNotFoundCheapestAndBestRatedHotel_ShouldReturnNull() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel=hotelReservation.cheapestAndBestRatedHotel(arrivalDate, departureDate,CustomerType.REWARD);
		Assert.assertEquals(null,hotel);
	}
	
	@Test
	public void givenDateRange_WhenFoundBestRatedHotel_ShouldReturnHotel() {
		
		Hotel hotel=hotelReservation.getBestRatedHotel(arrivalDate, departureDate);
		Assert.assertEquals("LakeWood",hotel.getHotelName());
	}
	
	@Test
	public void givenDateRange_WhenNoBestRatedHotelFound_ShouldReturnNull() {
		HotelReservation hotelReservation=new HotelReservation();
		Hotel hotel=hotelReservation.getBestRatedHotel(arrivalDate, departureDate);
		Assert.assertNull(hotel);
	}
	
	@Test
	public void givenDateRangeForRewardCustomer_WhenArrivaLDateIsNull_ShouldThrowException() {
		
		try {
			hotelReservation.cheapestAndBestRatedHotel(null, departureDate,CustomerType.REWARD);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_NULL,e.etype);
		}
	}
	
	@Test
	public void givenDateRangeForRewardCustomer_WhenDepartureDateIsNull_ShouldThrowException() {
		
		try {
			hotelReservation.cheapestAndBestRatedHotel(arrivalDate,null,CustomerType.REWARD);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_NULL,e.etype);
		}
	}
	
	@Test
	public void givenDateRangeForRewardCustomer_WhenArrivalDateIsAfterDepartureDate_ShouldThrowException() {
		LocalDate arrivalDate = LocalDate.of(2020, 9, 15);
		LocalDate departureDate = LocalDate.of(2020, 9, 10);
		try {
			hotelReservation.cheapestAndBestRatedHotel(arrivalDate,departureDate,CustomerType.REWARD);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_INVALID,e.etype);		
		}
	}
	
	@Test
	public void givenDateRangeForRewardCustomer_WhenCustomerFieldIsNull_ShouldThrowException() {
		try {
			hotelReservation.cheapestAndBestRatedHotel(arrivalDate,departureDate,null);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_INVALID,e.etype);		
		}
	}
	
	@Test
	public void givenDateRangeForRegularCustomer_WhenArrivaLDateIsNull_ShouldThrowException() {
		
		try {
			hotelReservation.cheapestAndBestRatedHotel(null, departureDate,CustomerType.REGULAR);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_NULL,e.etype);
		}
	}
	@Test
	public void givenDateRangeForRegularCustomer_WhenDepartueDateIsNull_ShouldThrowException() {
		
		try {
			hotelReservation.cheapestAndBestRatedHotel(arrivalDate, null,CustomerType.REGULAR);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_NULL,e.etype);
		}
	}
	
	@Test
	public void givenDateRangeForRegularCustomer_WhenArrivalDateIsAfterDepartureDate_ShouldThrowException() {
		LocalDate arrivalDate = LocalDate.of(2020, 9, 15);
		LocalDate departureDate = LocalDate.of(2020, 9, 10);
		try {
			hotelReservation.cheapestAndBestRatedHotel(arrivalDate,departureDate,CustomerType.REGULAR);
		} catch (HotelReservationException e) {
			Assert.assertEquals(exceptionType.ENTERED_INVALID,e.etype);		
		}
	}
	
	
}