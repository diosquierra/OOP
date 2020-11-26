package nsu.oop.calendar;

import java.time.format.DateTimeParseException;

public class MyDate {
    int day;
    int month;
    int year;

    public MyDate(){

    }
    public MyDate(int day, int month, int year){
        if(year < 0){
            throw new IllegalArgumentException("Incorrect date! Illegal year!");
        }
        if(month < 1 || month > 12 || day < 0 || year < 0){
            throw new IllegalArgumentException("Incorrect date! Illegal month!");
        }
        if((month == 2 && day > 28 && year % 4 != 0) || (month == 2 && day > 29 && year % 4 == 0)){
            throw new IllegalArgumentException("Incorrect date! Illegal day!");
        }
        if((day > 30) && ((month < 8 && month % 2 == 0) || (month > 7 && month % 2 != 0))){
            throw new IllegalArgumentException("Incorrect date! Illegal day!");
        }
        if((day > 31) && ((month < 8 && month % 2 != 0) || (month > 7 && month % 2 == 0))){
            throw new IllegalArgumentException("Incorrect date! Illegal day!");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String daysofdate(){
        if((Integer)day == null || (Integer)month == null || (Integer)year == null){
            throw new IllegalStateException("Date wasn't initialized!");
        }
        return null;
    }
}