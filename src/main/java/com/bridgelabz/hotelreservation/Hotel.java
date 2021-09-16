package com.bridgelabz.hotelreservation;

public class Hotel{
	    private String hotelName;
	    private int weekdayHotelRate;
	    private int weekendHotelRate;
	    private int hotelRating;
		public int getHotelRating() {
			return hotelRating;
		}

		public void setHotelRating(int hotelRating) {
			this.hotelRating = hotelRating;
		}

		public String getHotelName() {
			return hotelName;
		}
		
		public Hotel(String hotelName, int weekdayHotelRate, int weekendHotelRate,int hotelRating) {
			super();
			this.hotelName = hotelName;
			this.weekdayHotelRate = weekdayHotelRate;
			this.weekendHotelRate = weekendHotelRate;
			this.hotelRating=hotelRating;
		}

		public int getWeekdayHotelRate() {
			return weekdayHotelRate;
		}

		public void setWeekdayHotelRate(int weekdayHotelRate) {
			this.weekdayHotelRate = weekdayHotelRate;
		}

		public int getWeekendHotelRate() {
			return weekendHotelRate;
		}

		public void setWeekendHotelRate(int weekendHotelRate) {
			this.weekendHotelRate = weekendHotelRate;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
		
	}
