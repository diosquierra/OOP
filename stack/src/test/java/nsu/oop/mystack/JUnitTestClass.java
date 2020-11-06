package nsu.oop.mystack;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JUnitTestClass {
    @Test
    void testRealloc(){
        MyStack<Integer> testStack = new MyStack<>(2);
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        assertEquals(3, testStack.pop());
        assertEquals(2, testStack.pop());
        assertEquals(1, testStack.pop());
    }

    @Test
    void testExceptions() throws NoSuchElementException {
        MyStack<Integer> testStack = new MyStack<>(2);
        testStack.push(1);
        testStack.push(2);
        testStack.pop();
        testStack.pop();
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            testStack.pop();
        });
    }

    @Test
    void testTask(){
        MyStack<Object> testStack = new MyStack<>(3);
        testStack.push(2);
        testStack.push(7);
        testStack.pop();
        testStack.count();
        assertEquals(2, testStack.pop());
    }

    @Test
    void testUniversalStack(){
        MyStack<Object> testStack = new MyStack<>(9);
        testStack.push((byte) 1);
        testStack.push((short) 2);
        testStack.push(3);
        testStack.push((long) 4);
        testStack.push(2.5f);
        testStack.push(3.55);
        testStack.push('a');
        testStack.push("Hello world!");
        testStack.push(true);

        assertEquals(testStack.pop(), true);
        assertEquals(testStack.pop(), "Hello world!");
        assertEquals(testStack.pop(), 'a');
        assertEquals(testStack.pop(), 3.55);
        assertEquals(testStack.pop(), 2.5f);
        assertEquals(testStack.pop(), (long) 4);
        assertEquals(testStack.pop(), 3);
        assertEquals(testStack.pop(), (short) 2);
        assertEquals(testStack.pop(), (byte) 1);
    }

    @Test
    void testSomeStacks(){
        MyStack<Integer> testStackOne = new MyStack<>(4);
        MyStack<Integer> testStackTwo = new MyStack<>(5);
        int stackOneCount;
        int stackOneCountS = 4;
        int stackTwoCount;
        int stackTwoCountS = 5;

        testStackOne.push(5);
        testStackTwo.push(1);
        testStackOne.push(6);
        testStackTwo.push(2);
        testStackOne.push(7);
        testStackTwo.push(3);
        testStackOne.push(8);
        testStackTwo.push(4);
        testStackTwo.push(5);
        stackOneCount = testStackOne.count();
        stackTwoCount = testStackTwo.count();

        assertEquals(testStackOne.pop(), 8);
        assertEquals(testStackOne.pop(), 7);
        assertEquals(testStackOne.pop(), 6);
        assertEquals(testStackOne.pop(), 5);
        assertEquals(testStackTwo.pop(), 5);
        assertEquals(testStackTwo.pop(), 4);
        assertEquals(testStackTwo.pop(), 3);
        assertEquals(testStackTwo.pop(), 2);
        assertEquals(testStackTwo.pop(), 1);
        assertEquals(stackOneCount, stackOneCountS);
        assertEquals(stackTwoCount, stackTwoCountS);
    }

    @Test
    void testByte() {
        MyStack<Byte> testByte = new MyStack<>(3);
        byte testBytePop;
        byte testBytePopS = 2;
        int testCount;
        int testCountS = 3;

        testByte.push((byte) 1);
        testByte.push((byte) 2);
        testBytePop = testByte.pop();
        testByte.push((byte) 3);
        testByte.push((byte) 4);
        testCount = testByte.count();

        assertEquals(testBytePop, testBytePopS);
        assertEquals(testCount, testCountS);
        assertEquals(testByte.pop(), (byte) 4);
        assertEquals(testByte.pop(), (byte) 3);
        assertEquals(testByte.pop(), (byte) 1);
    }

    @Test
    void testShort() {
        MyStack<Short> testShort = new MyStack<>(3);
        short testShortPop;
        short testShortPopS = 2;
        int testCount;
        int testCountS = 3;

        testShort.push((short) 1);
        testShort.push((short) 2);
        testShortPop = testShort.pop();
        testShort.push((short) 3);
        testShort.push((short) 4);
        testCount = testShort.count();

        assertEquals(testShortPop, testShortPopS);
        assertEquals(testCount, testCountS);
        assertEquals(testShort.pop(), (short) 4);
        assertEquals(testShort.pop(), (short) 3);
        assertEquals(testShort.pop(), (short) 1);
    }

    @Test
    void testInteger() {
        MyStack<Integer> testInteger = new MyStack<>(3);
        int testIntegerPop;
        int testIntegerPopS = 2;
        int testCount;
        int testCountS = 3;

        testInteger.push(1);
        testInteger.push(2);
        testIntegerPop = testInteger.pop();
        testInteger.push(3);
        testInteger.push(4);
        testCount = testInteger.count();

        assertEquals(testIntegerPop, testIntegerPopS);
        assertEquals(testCount, testCountS);
        assertEquals(testInteger.pop(), 4);
        assertEquals(testInteger.pop(), 3);
        assertEquals(testInteger.pop(), 1);
    }

    @Test
    void testLong() {
        MyStack<Long> testLong = new MyStack<>(3);
        long testLongPop;
        long testLongPopS = 2;
        int testCount;
        int testCountS = 3;

        testLong.push((long) 1);
        testLong.push((long) 2);
        testLongPop = testLong.pop();
        testLong.push((long) 3);
        testLong.push((long) 4);
        testCount = testLong.count();

        assertEquals(testLongPop, testLongPopS);
        assertEquals(testCount, testCountS);
        assertEquals(testLong.pop(), (long) 4);
        assertEquals(testLong.pop(), (long) 3);
        assertEquals(testLong.pop(), (long) 1);
    }

    @Test
    void testFloat() {
        MyStack<Float> testFloat = new MyStack<>(3);
        float testFloatPop;
        float testFloatPopS = 2.4f;
        int testCount;
        int testCountS = 3;

        testFloat.push(1.5f);
        testFloat.push(2.4f);
        testFloatPop = testFloat.pop();
        testFloat.push(3.67f);
        testFloat.push(4.598f);
        testCount = testFloat.count();

        assertEquals(testFloatPop, testFloatPopS);
        assertEquals(testCount, testCountS);
        assertEquals(testFloat.pop(), 4.598f);
        assertEquals(testFloat.pop(), 3.67f);
        assertEquals(testFloat.pop(), 1.5f);
    }

    @Test
    void testDouble() {
        MyStack<Double> testDouble = new MyStack<>(3);
        double testDoublePop;
        double testDoublePopS = 2.4;
        int testCount;
        int testCountS = 3;

        testDouble.push(1.5);
        testDouble.push(2.4);
        testDoublePop = testDouble.pop();
        testDouble.push(3.67);
        testDouble.push(4.598);
        testCount = testDouble.count();

        assertEquals(testDoublePop, testDoublePopS);
        assertEquals(testCount, testCountS);
        assertEquals(testDouble.pop(), 4.598);
        assertEquals(testDouble.pop(), 3.67);
        assertEquals(testDouble.pop(), 1.5);
    }

    @Test
    void testBoolean() {
        MyStack<Boolean> testBoolean = new MyStack<>(3);
        boolean testBooleanPop;
        boolean testBooleanPopS = false;
        int testCount;
        int testCountS = 3;

        testBoolean.push(true);
        testBoolean.push(false);
        testBooleanPop = testBoolean.pop();
        testBoolean.push(false);
        testBoolean.push(false);
        testCount = testBoolean.count();

        assertEquals(testBooleanPop, testBooleanPopS);
        assertEquals(testCount, testCountS);
        assertEquals(testBoolean.pop(), false);
        assertEquals(testBoolean.pop(), false);
        assertEquals(testBoolean.pop(), true);
    }

    @Test
    void testCharacter() {
        MyStack<Character> testCharacter = new MyStack<>(3);
        char testCharacterPop;
        char testCharacterPopS = 'a';
        int testCount;
        int testCountS = 3;

        testCharacter.push('b');
        testCharacter.push('a');
        testCharacterPop = testCharacter.pop();
        testCharacter.push('c');
        testCharacter.push('d');
        testCount = testCharacter.count();

        assertEquals(testCharacterPop, testCharacterPopS);
        assertEquals(testCount, testCountS);
        assertEquals(testCharacter.pop(), 'd');
        assertEquals(testCharacter.pop(), 'c');
        assertEquals(testCharacter.pop(), 'b');
    }

    @Test
    void testString() {
        MyStack<String> testString = new MyStack<>(3);
        String testStringPop;
        String testStringPopS = "is";
        int testCount;
        int testCountS = 3;

        testString.push("This");
        testString.push("is");
        testStringPop = testString.pop();
        testString.push("String");
        testString.push("type");
        testCount = testString.count();

        assertEquals(testStringPop, testStringPopS);
        assertEquals(testCount, testCountS);
        assertEquals(testString.pop(), "type");
        assertEquals(testString.pop(), "String");
        assertEquals(testString.pop(), "This");
    }
}
