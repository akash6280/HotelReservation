package com.bridgelabz.hotelreservation;

import java.time.LocalDate;

public interface HotelReservationIF {
	public boolean addHotel(Hotel hotel);
	public Hotel cheapestHotel(LocalDate arrivalDate,LocalDate departureDate,CustomerType customerType);
	public Hotel cheapestAndBestRatedHotel(LocalDate arrivalDate,LocalDate departureDate,CustomerType customerType);
	public Hotel getBestRatedHotel(LocalDate arrivalDate,LocalDate departureDate);
}
