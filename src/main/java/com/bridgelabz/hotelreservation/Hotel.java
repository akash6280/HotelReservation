package com.bridgelabz.hotelreservation;

public class Hotel{
	    private String hotelName;
	    private int weekdayHotelRate;
	    private int weekendHotelRate;
	    private int hotelRating;
	    private int rewardWeekDayHotelRate;
		private int rewardWeekEndHotelRate;
		
		public int getRewardWeekDayHotelRate() {
			return rewardWeekDayHotelRate;
		}

		public void setRewardWeekDayHotelRate(int rewardWeekDayHotelRate) {
			this.rewardWeekDayHotelRate = rewardWeekDayHotelRate;
		}

		public int getRewardWeekEndHotelRate() {
			return rewardWeekEndHotelRate;
		}

		public void setRewardWeekEndHotelRate(int rewardWeekEndHotelRate) {
			this.rewardWeekEndHotelRate = rewardWeekEndHotelRate;
		}

		public int getHotelRating() {
			return hotelRating;
		}

		public void setHotelRating(int hotelRating) {
			this.hotelRating = hotelRating;
		}

		public String getHotelName() {
			return hotelName;
		}
		
		public Hotel(String hotelName, int weekdayHotelRate, int weekendHotelRate, int hotelRating,int rewardWeekDayHotelRate, int rewardWeekEndHotelRate) {
			super();
			this.hotelName = hotelName;
			this.weekdayHotelRate = weekdayHotelRate;
			this.weekendHotelRate = weekendHotelRate;
			this.hotelRating = hotelRating;
			this.rewardWeekDayHotelRate = rewardWeekDayHotelRate;
			this.rewardWeekEndHotelRate = rewardWeekEndHotelRate;
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
