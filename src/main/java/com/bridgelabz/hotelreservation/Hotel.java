package com.bridgelabz.hotelreservation;

public class Hotel{
	    private String hotelName;
	    private int hotelRate;
	    
		public String getHotelName() {
			return hotelName;
		}
		
		public Hotel(String hotelName, int hotelRate) {
			super();
			this.hotelName = hotelName;
			this.hotelRate = hotelRate;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
		public int getHotelRate() {
			return hotelRate;
		}
		public void setHotelRate(int hotelRate) {
			this.hotelRate = hotelRate;
		}
	}
