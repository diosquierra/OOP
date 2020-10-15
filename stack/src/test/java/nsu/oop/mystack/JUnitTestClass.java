package nsu.oop.mystack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTestClass {
    @Test
    void testByte(){
        byte[] test1 = new byte[3];
        byte[] test1s = {1, 3, 4};
        byte testByteVar1;
        byte testByteVar1S = 2;
        int testCount;
        int testCountS = 3;

        MyStack.CrtByte testByte = new MyStack.CrtByte(test1);

        testByte.push((byte) 1);
        testByte.push((byte) 2);
        testByteVar1 = testByte.pop();
        testByte.push((byte) 3);
        testByte.push((byte) 4);
        testCount = testByte.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testByteVar1, testByteVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testShort(){
        short[] test1 = new short[3];
        short[] test1s = {1, 3, 4};
        short testShortVar1;
        short testShortVar1S = 2;
        int testCount;
        int testCountS = 3;

        MyStack.CrtShort testShort = new MyStack.CrtShort(test1);

        testShort.push((short) 1);
        testShort.push((short) 2);
        testShortVar1 = testShort.pop();
        testShort.push((short) 3);
        testShort.push((short) 4);
        testCount = testShort.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testShortVar1, testShortVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testInteger(){
        int[] test1 = new int[4];
        int[] test1s = {1, 2, 5, 6};
        int testIntVar1;
        int testIntVar1S = 3;
        int testCount;
        int testCountS = 4;

        int[] test2 = new int[3];
        int[] test2s = {10, 8, 7};

        MyStack.CrtInt testInt1 = new MyStack.CrtInt(test1);
        MyStack.CrtInt testInt2 = new MyStack.CrtInt(test2);

        testInt1.push(1);
        testInt1.push(2);
        testInt1.push(3);
        testInt1.push(4);
        testInt1.pop();
        testIntVar1 = testInt1.pop();
        testInt1.push(5);
        testInt1.push(6);
        testCount = testInt1.count();

        testInt2.push(10);
        testInt2.push(9);
        testInt2.pop();
        testInt2.push(8);
        testInt2.push(7);

        assertArrayEquals(test1, test1s);
        assertArrayEquals(test2, test2s);
        assertEquals(testIntVar1, testIntVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testLong(){
        long[] test1 = new long[3];
        long[] test1s = {1, 3, 4};
        long testLongVar1;
        long testLongVar1S = 2;
        int testCount;
        int testCountS = 3;

        MyStack.CrtLong testLong = new MyStack.CrtLong(test1);

        testLong.push(1);
        testLong.push(2);
        testLongVar1 = testLong.pop();
        testLong.push(3);
        testLong.push(4);
        testCount = testLong.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testLongVar1, testLongVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testFloat(){
        float[] test1 = new float[3];
        float[] test1s = {1.3f, 3.5f, 4.89f};
        float testFloatVar1;
        float testFloatVar1S = 2.123f;
        int testCount;
        int testCountS = 3;

        MyStack.CrtFloat testFloat = new MyStack.CrtFloat(test1);

        testFloat.push(1.3f);
        testFloat.push(2.123f);
        testFloatVar1 = testFloat.pop();
        testFloat.push(3.5f);
        testFloat.push(4.89f);
        testCount = testFloat.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testFloatVar1, testFloatVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testDouble(){
        double[] test1 = new double[3];
        double[] test1s = {1.3, 3.5, 4.89};
        double testDoubleVar1;
        double testDoubleVar1S = 2.123;
        int testCount;
        int testCountS = 3;

        MyStack.CrtDouble testDouble = new MyStack.CrtDouble(test1);

        testDouble.push(1.3);
        testDouble.push(2.123);
        testDoubleVar1 = testDouble.pop();
        testDouble.push(3.5);
        testDouble.push(4.89);
        testCount = testDouble.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testDoubleVar1, testDoubleVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testBoolean(){
        boolean[] test1 = new boolean[3];
        boolean[] test1s = {true, false, false};
        boolean testBooleanVar1;
        boolean testBooleanVar1S = false;
        int testCount;
        int testCountS = 3;

        MyStack.CrtBoolean testBoolean = new MyStack.CrtBoolean(test1);

        testBoolean.push(true);
        testBoolean.push(false);
        testBooleanVar1 = testBoolean.pop();
        testBoolean.push(false);
        testBoolean.push(false);
        testCount = testBoolean.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testBooleanVar1, testBooleanVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testChar(){
        char[] test1 = new char[3];
        char[] test1s = {'v', 'm', 'c'};
        char testCharVar1;
        char testCharVar1S = 'a';
        int testCount;
        int testCountS = 3;

        MyStack.CrtChar testChar= new MyStack.CrtChar(test1);

        testChar.push('v');
        testChar.push('a');
        testCharVar1 = testChar.pop();
        testChar.push('m');
        testChar.push('c');
        testCount = testChar.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testCharVar1, testCharVar1S);
        assertEquals(testCount, testCountS);
    }

    @Test
    void testString(){
        String[] test1 = new String[3];
        String[] test1s = {"Jesus Christ", "Mercury", "Mars"};
        String testStringVar1;
        String testStringVar1S = "Pluto";
        int testCount;
        int testCountS = 3;

        MyStack.CrtString testString= new MyStack.CrtString(test1);

        testString.push("Jesus Christ");
        testString.push("Pluto");
        testStringVar1 = testString.pop();
        testString.push("Mercury");
        testString.push("Mars");
        testCount = testString.count();

        assertArrayEquals(test1, test1s);
        assertEquals(testStringVar1, testStringVar1S);
        assertEquals(testCount, testCountS);
    }
}
