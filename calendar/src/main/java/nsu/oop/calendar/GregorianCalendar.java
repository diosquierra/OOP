package nsu.oop.calendar;

/**
 * GregorianCalendar class realises operations with MyDate class
 */
public class GregorianCalendar {
    /**
     * getNameOfWeek is public static method which is calculating
     * name of day of week using offsets.
     *
     * @param date - date.
     * @return name of week as String.
     */
    public static DayOfWeek getNameOfWeek(MyDate date){
        int day;

        int centuryOffset;
        int yearOffset;
        int monthOffset;
        int dayOffset;

        int century;
        int buffer;

        int year;

        century = date.year / 100;
        buffer = century;

        if(buffer % 4 == 0){
            buffer++;
        }

        while(buffer % 4 != 0){
            buffer++;
        }

        buffer--;
        centuryOffset = (buffer - century) * 2;

        year = date.year % 100;
        yearOffset = (year + (year / 4)) % 7;

        if(isYearLeap(date.year) && (date.month == 1 || date.month == 2)){
            yearOffset--;
        }

        monthOffset = getMonthOffset(date.month);

        dayOffset = date.day % 7;

        day = (centuryOffset + yearOffset + monthOffset + dayOffset) % 7;
        DayOfWeek[] returnDayArray = DayOfWeek.values();
        return returnDayArray[day];
    }

    /**
     * getMonthOffset is private static method which
     * calculates month offset.
     * @param month - month.
     * @return month offset.
     * @throws IllegalArgumentException if month is incorrect.
     */
    private static int getMonthOffset(int month){
        switch(month){
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 6;
            case 8:
                return 2;
            case 9:
                return 5;
            case 10:
                return 0;
            case 11:
                return 3;
            case 12:
                return 5;
            default:
                throw new IllegalArgumentException("Unexpected value: " + month);
        }
    }

    /**
     * dateSubDate is public static method which is calculating
     * amount of days between two dates (dateTwo - dateOne).
     * @param dateOne - first date.
     * @param dateTwo - second date.
     * @return MyDate result - amount of days in days, months, years.
     */
    public static MyDate dateSubDate(MyDate dateOne, MyDate dateTwo){
        MyDate returnDate = new MyDate();
        returnDate.year = dateTwo.year - dateOne.year;
        if(dateTwo.month - dateOne.month > 0){
            returnDate.month = dateTwo.month - dateOne.month;
        }else{
            returnDate.month = 12 - (dateOne.month - dateTwo.month);
            returnDate.year--;
        }
        if(dateTwo.day - dateOne.day > 0){
            returnDate.day = dateTwo.day - dateOne.day;
        }else{
            returnDate.month--;
            returnDate.day = daysInMonth(returnDate.month, returnDate.year) - (dateOne.day - dateTwo.day);
            if(returnDate.month <= 0){
                returnDate.month = 12 - (dateOne.month - dateTwo.month);
                returnDate.year--;
            }
        }

        if(returnDate.day > daysInMonth(returnDate.month, returnDate.year)){
            returnDate.day = 1 + (returnDate.day - daysInMonth(returnDate.month, returnDate.year));
            returnDate.month++;
            if(returnDate.month > 12){
                returnDate.month = 1;
            }
        }

        return returnDate;
    }

    /**
     * datePlusDay is public static method which is calculating
     * date after amount of days.
     * @param date - date.
     * @param days - amount of days.
     * @return MyDate returnDate - result
     */
    public static MyDate datePlusDay(MyDate date, int days){
        MyDate returnDate = new MyDate(date.day, date.month, date.year);
        int dayPull = days;
        while(dayPull / 365 > 0){
            if(isYearLeap(returnDate.year)){
                dayPull--;
            }
            returnDate.year++;
            dayPull -= 365;
        }
        while(dayPull >= 31){
            dayPull -= daysInMonth(returnDate.month, returnDate.year);
            returnDate.month++;
            if(returnDate.month > 12){
                returnDate.month = 1;
                returnDate.year++;
            }
        }
        if (dayPull >= 28){
            if(daysInMonth(returnDate.month, returnDate.year) == 30 && dayPull >= 30){
                dayPull -= daysInMonth(returnDate.month, returnDate.year);
                returnDate.month++;
            }
            if(daysInMonth(returnDate.month, returnDate.year) == 28 && dayPull >= 28){
                dayPull -= daysInMonth(returnDate.month, returnDate.year);
                returnDate.month++;
            }
            if(daysInMonth(returnDate.month, returnDate.year) == 29 && dayPull >= 29){
                dayPull -= daysInMonth(returnDate.month, returnDate.year);
                returnDate.month++;
            }
            if(returnDate.month > 12){
                returnDate.month = 1;
            }
        }
        returnDate.day = returnDate.day + dayPull;
        if(returnDate.day > daysInMonth(returnDate.month, returnDate.year)){
            returnDate.day = returnDate.day - daysInMonth(returnDate.month, returnDate.year);
            returnDate.month++;
            if(returnDate.month > 12){
                returnDate.month = 1;
                returnDate.year++;
            }
        }
        return returnDate;
    }

    /**
     * daysInMonth is private static method which is calculating
     * how many days in current months.
     * @param month - month.
     * @param year - year.
     * @return int - amount of days in current month.
     */
    private static int daysInMonth(int month, int year){
        if (isYearLeap(year)) {
            if (month == 2) {
                return 29;
            }
        }else{
            if (month == 2) {
                return 28;
            }
        }

        if((month < 8 && month % 2 == 0) || (month > 7 && month % 2 != 0)){
            return 30;
        }

        if((month < 8 && month % 2 != 0) || (month > 7 && month % 2 == 0)){
            return 31;
        }
        throw new IllegalArgumentException("Illegal month");
    }

    /**
     * dateSubDay is public static method which is calculating
     * date before amount of days.
     * @param date - date.
     * @param days - amount of days.
     * @return MyDate returnDate - result
     */
    public static MyDate dateSubDays(MyDate date, int days){
        MyDate returnDate = new MyDate(date.day, date.month, date.year);
        int dayPull = days;
        while(dayPull / 365 > 0){
            if(isYearLeap(returnDate.year)){
                dayPull--;
            }
            returnDate.year--;
            dayPull -= 365;
        }

        while(dayPull >= 31){
            returnDate.month--;
            dayPull -= daysInMonth(returnDate.month, returnDate.year);
            if(returnDate.month == 0){
                returnDate.month = 12;
                returnDate.year--;
            }
        }
        if (dayPull >= 28){
            if(daysInMonth(returnDate.month - 1, returnDate.year) == 30 && dayPull >= 30){
                dayPull -= daysInMonth(returnDate.month - 1, returnDate.year);
                returnDate.month--;
            }
            if(daysInMonth(returnDate.month - 1, returnDate.year) == 28 && dayPull >= 28){
                dayPull -= daysInMonth(returnDate.month, returnDate.year);
                returnDate.month--;
            }
            if(daysInMonth(returnDate.month - 1, returnDate.year) == 29 && dayPull >= 29){
                dayPull -= daysInMonth(returnDate.month, returnDate.year);
                returnDate.month--;
            }
            if(returnDate.month > 12){
                returnDate.month = 1;
                returnDate.year++;
            }
        }
        returnDate.day = returnDate.day - dayPull;
        if(returnDate.day > daysInMonth(returnDate.month, returnDate.year) || returnDate.day < 1){
            returnDate.month--;
            returnDate.day = 1 + (returnDate.day - daysInMonth(returnDate.month, returnDate.year));
            if(returnDate.day <= 0){
                returnDate.day = daysInMonth(returnDate.month, returnDate.year) + returnDate.day;
            }else{
                returnDate.day = 1 + (returnDate.day - daysInMonth(returnDate.month, returnDate.year));
                returnDate.month++;
            }
            if(returnDate.month > 12){
                returnDate.month = 1;
                returnDate.year++;
            }
            if(returnDate.month <= 0){
                returnDate.month = 12;
                returnDate.year--;
            }
        }
        return returnDate;
    }

    /**
     * datePlusMonth is public static method which is calculating
     * date after amount of months.
     * @param date - date.
     * @param months - amount of months.
     * @return MyDate returnDate - result.
     */
    public static MyDate datePlusMonth(MyDate date, int months){
        MyDate returnDate = new MyDate(date.day, date.month, date.year);
        if (returnDate.month + months <= 12) {
            returnDate.month += months;
        }else{
            int buffer = returnDate.month + months;
            returnDate.month = buffer % 12;
            returnDate.year += buffer / 12;
        }
        int daysInCurrent = daysInMonth(returnDate.month, returnDate.year);
        if(daysInCurrent < returnDate.day){
            returnDate.day -= daysInCurrent;
            returnDate.month++;
            if(returnDate.month > 12){
                returnDate.month = 1;
                returnDate.year++;
            }
        }
        return returnDate;
    }

  /**
   * dateSubMonth is public static method which is calculating
   * date before amount of months.
   * @param date - date.
   * @param months - amount of months.
   * @return MyDate returnDate - result.
   */
  public static MyDate dateSubMonth(MyDate date, int months) {
        MyDate returnDate = new MyDate(date.day, date.month, date.year);
        if (returnDate.month - months >= 1) {
            returnDate.month -= months;
        }else{
            int years = months / 12;
            int monthPull = months % 12;
            returnDate.year -= years;
            if(returnDate.month - monthPull <= 0){
                returnDate.month = 12 - (monthPull - returnDate.month);
                returnDate.year--;
            }else{
                returnDate.month -= monthPull;
            }
            int daysInCurrent = daysInMonth(returnDate.month, returnDate.year);
            if(daysInCurrent < returnDate.day){
                returnDate.day -= daysInCurrent;
                returnDate.month++;
                if(returnDate.month > 12){
                    returnDate.month = 1;
                    returnDate.year++;
                }
            }
        }
        return returnDate;
    }

    /**
     * datePlusYear is public static method which is calculating
     * date after amount of years.
     * @param date - date.
     * @param year - amount of years.
     * @return MyDate returnDate - result.
     */
    public static MyDate datePlusYear(MyDate date, int year){
        MyDate returnDate = new MyDate(date.day, date.month, date.year);
        returnDate.year += year;
        int daysInCurrent = daysInMonth(returnDate.month, returnDate.year);
        if(daysInCurrent < returnDate.day){
            returnDate.day -= daysInCurrent;
            returnDate.month++;
            if(returnDate.month > 12){
                returnDate.month = 1;
                returnDate.year++;
            }
        }
        return returnDate;
    }

    /**
     * dateSubYear is public static method which is calculating
     * date before amount of years.
     * @param date - date.
     * @param year - amount of years.
     * @return MyDate returnDate - result.
     */
    public static MyDate dateSubYear(MyDate date, int year){
        MyDate returnDate = new MyDate(date.day, date.month, date.year);
        returnDate.year -= year;
        int daysInCurrent = daysInMonth(returnDate.month, returnDate.year);
        if(daysInCurrent < returnDate.day){
            returnDate.day -= daysInCurrent;
            returnDate.month++;
            if(returnDate.month > 12){
                returnDate.month = 1;
                returnDate.year++;
            }
        }
        return returnDate;
    }

    /**
     * isYearLeap is private static method which is calculating
     * is this year leap.
     * @param year - year.
     * @return boolean. If year is leap - true, else - false.
     */
    private static boolean isYearLeap(int year){
        if(year % 400 == 0){
            return true;
        }
        if(year % 100 == 0){
            return false;
        }
        return year % 4 == 0;
    }



}
