package nsu.oop.calendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GregorianCalendarJUnitTest {
    @Test
    void requestedTestOne(){
        MyDate today = new MyDate(26,11,2020);
        MyDate result;
        result = GregorianCalendar.datePlusDay(today, 1024);
        assertEquals(16,result.day);
        assertEquals(9,result.month);
        assertEquals(2023,result.year); //https://planetcalc.ru/410/
    }
    @Test
    void requestedTestTwo(){
        MyDate today = new MyDate(26,11,2020);
        MyDate victory = new MyDate(9,5,1945);
        MyDate result;
        result = GregorianCalendar.dateSubDate(victory, today);
        assertEquals(17,result.day);
        assertEquals(6,result.month);
        assertEquals(75,result.year); //https://planetcalc.ru/274/
    }
    @Test
    void requestedTestThree(){
        MyDate birthday = new MyDate(29,1,2001);
        assertEquals("Monday", GregorianCalendar.getNameOfWeek(birthday)); //calendar
    }
    @Test
    void requestedTestFour(){
        MyDate today = new MyDate(26,11,2020);
        MyDate result;
        result = GregorianCalendar.datePlusDay(today, 17 * 7);
        assertEquals(25, result.day);
        assertEquals(3, result.month);
        assertEquals(2021, result.year); //https://planetcalc.ru/410/
    }
    @Test
    void requestedTestFive(){
        MyDate today = new MyDate(26,11,2020);
        MyDate newYear = new MyDate(1,1,2021);
        MyDate result;
        result = GregorianCalendar.dateSubDate(today, newYear);
        assertEquals(6,result.day);
        assertEquals(1,result.month);
        assertEquals(0,result.year); //https://planetcalc.ru/274/
    }
    @Test
    void requestedTestSix(){
        MyDate result = new MyDate(13,12,2020);
        while(GregorianCalendar.getNameOfWeek(result) != "Friday"){
            result = GregorianCalendar.datePlusMonth(result, 1);
        }
        assertEquals(13,result.day);
        assertEquals(8,result.month);
        assertEquals(2021,result.year); //calendar
    }
}
