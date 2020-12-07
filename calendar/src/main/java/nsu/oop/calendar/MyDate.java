package nsu.oop.calendar;

/**
 * MyDate is class which realises date
 */
public class MyDate {
    /**
     * Fields.
     */
    int day;
    int month;
    int year;

    /**
     * Constructor with no fields.
     */
    public MyDate(){

    }

    /**
     * Constructor with fields: day, month, year.
     * @param day
     * @param month
     * @param year
     * @throws IllegalArgumentException if date is incorrect.
     */
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
}
