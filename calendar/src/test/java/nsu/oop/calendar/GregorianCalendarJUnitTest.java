package nsu.oop.calendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import java.util.Date;
//import java.util.Calendar;

public class GregorianCalendarJUnitTest {
    @Test
    void testOne(){
        Date test = new Date(15,7,1921);
        Date test1 = new Date(23,6, 1986);
        Date test2 = new Date(20,11, 2020);
        Date test3 = new Date();
        Date test4 = new Date();

        test3 = GregorianCalendar.datePlusMonth(test2, -50);
        test4 = GregorianCalendar.dateSubMonth(test2, 50);

        //System.out.println(GregorianCalendar.getNameOfWeek(test1));
        //System.out.println(GregorianCalendar.getNameOfWeek(test2));
        int a = 0;


    }
    @Test
    void requestedTestTwo(){

    }
    @Test
    void requestedTestThree(){
        Date birthday = new Date(29,1,2001);
        assertEquals("Monday", GregorianCalendar.getNameOfWeek(birthday));
    }
}
