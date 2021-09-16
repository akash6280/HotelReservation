package com.bridgelabz.hotelreservation;

public class Hotel{
	    private String hotelName;
	    private int weekdayHotelRate;
	    private int weekendHotelRate;
	    
		public String getHotelName() {
			return hotelName;
		}
		
		public Hotel(String hotelName, int weekdayHotelRate, int weekendHotelRate) {
			super();
			this.hotelName = hotelName;
			this.weekdayHotelRate = weekdayHotelRate;
			this.weekendHotelRate = weekendHotelRate;
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
