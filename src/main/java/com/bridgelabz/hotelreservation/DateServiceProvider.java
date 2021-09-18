package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class DateServiceProvider {
	int noOfWeekDay=0;
	int noOfWeekEnd=0;
	int noOftotalDays=0;
	
	public  int getNumOfWeekEnd(LocalDate arrivalDate,LocalDate departureDate) {
		
		while(arrivalDate.compareTo(departureDate) <=0) {
			if(arrivalDate.getDayOfWeek()==DayOfWeek.SATURDAY||arrivalDate.getDayOfWeek()==DayOfWeek.SUNDAY)
				noOfWeekEnd++;
			arrivalDate=arrivalDate.plusDays(1);
		}
		return noOfWeekEnd;
	}
	public  int getNumOfWeekDay(LocalDate arrivalDate,LocalDate departureDate) {
		
		
		return Period.between(arrivalDate, departureDate).getDays()+1-noOfWeekEnd;
	}
}