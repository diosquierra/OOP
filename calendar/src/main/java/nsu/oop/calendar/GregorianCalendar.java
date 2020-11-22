package nsu.oop.calendar;

public class GregorianCalendar{
    public static String getNameOfWeek(Date date){
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

        switch(date.month){
            case 1:
                monthOffset = 0;
                break;
            case 2:
                monthOffset = 3;
                break;
            case 3:
                monthOffset = 3;
                break;
            case 4:
                monthOffset = 6;
                break;
            case 5:
                monthOffset = 1;
                break;
            case 6:
                monthOffset = 4;
                break;
            case 7:
                monthOffset = 6;
                break;
            case 8:
                monthOffset = 2;
                break;
            case 9:
                monthOffset = 5;
                break;
            case 10:
                monthOffset = 0;
                break;
            case 11:
                monthOffset = 3;
                break;
            case 12:
                monthOffset = 5;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + date.month);
        }

        dayOffset = date.day % 7;

        day = (centuryOffset + yearOffset + monthOffset + dayOffset) % 7;

        switch(day){
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
        }
        throw new IllegalStateException("Illegal data!");
    }

    public static Date dateSubDate(Date dateOne, Date dateTwo){
        Date returnDate = new Date();
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
            returnDate.day = 1 + (dateOne.day - dateTwo.day);
            returnDate.month--;
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

    public static Date datePlusDay(Date date, int days){
        Date returnDate = new Date(date.day, date.month, date.year);
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
            returnDate.day = 1 + (returnDate.day - daysInMonth(returnDate.month, returnDate.year));
            returnDate.month++;
            if(returnDate.month > 12){
                returnDate.month = 1;
            }
        }
        return returnDate;
    }

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

    public static Date dateSubDays(Date date, int days){
        Date returnDate = new Date(date.day, date.month, date.year);
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
            }
            if(returnDate.month <= 0){
                returnDate.month = 12;
            }
        }
        return returnDate;
    }

    public static Date datePlusMonth(Date date, int months){
        Date returnDate = new Date(date.day, date.month, date.year);
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
        }
        return returnDate;
    }

    public static Date dateSubMonth(Date date, int months){
        Date returnDate = new Date(date.day, date.month, date.year);
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
            }
        }
        return returnDate;
    }

    public static Date datePlusYear(Date date, int year){
        Date returnDate = new Date(date.day, date.month, date.year);
        returnDate.year += year;
        int daysInCurrent = daysInMonth(returnDate.month, returnDate.year);
        if(daysInCurrent < returnDate.day){
            returnDate.day -= daysInCurrent;
            returnDate.month++;
        }
        return returnDate;
    }

    public static Date dateSubYear(Date date, int year){
        Date returnDate = new Date(date.day, date.month, date.year);
        returnDate.year -= year;
        int daysInCurrent = daysInMonth(returnDate.month, returnDate.year);
        if(daysInCurrent < returnDate.day){
            returnDate.day -= daysInCurrent;
            returnDate.month++;
        }
        return returnDate;
    }

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
