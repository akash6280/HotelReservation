package com.bridgelabz.hotelreservation;

public class HotelReservationException extends RuntimeException{
	
	enum exceptionType{
		ENTERED_NULL,
		ENTERED_EMPTY,
		ENTERED_INVALID,
	}
	exceptionType etype;
	public HotelReservationException(exceptionType type, String message) {
		super(message);
		this.etype = type;
	}
}
