import nsu.oop.heapsort.HeapSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class JUnitTestClass {
    HeapSort sorting = new HeapSort();
    @Test
    void testOne(){
        int[] test1 = {1, 2, 3, 4, 5, 6};
        int[] test1s = {1, 2, 3, 4, 5, 6};
        sorting.sort(test1);
        assertArrayEquals(test1, test1s);
    }
    @Test
    void testTwo(){
        int[] test2 = {6, 5, 4, 3, 2, 1};
        int[] test2s = {1, 2, 3, 4, 5, 6};
        sorting.sort(test2);
        assertArrayEquals(test2, test2s);
    }
    @Test
    void testThree(){
        int[] test3 = {100, 14, 10, -100, 5};
        int[] test3s = {-100, 5, 10, 14, 100};
        sorting.sort(test3);
        assertArrayEquals(test3, test3s);
    }
    @Test
    void testFour(){
        int[] test4 = {100, 100, 50, 60, 20};
        int[] test4s = {20, 50, 60, 100, 100};
        sorting.sort(test4);
        assertArrayEquals(test4, test4s);
    }
    @Test
    void testFive(){
        int[] test5 = {6, 3, 2, - 10, -10};
        int[] test5s = {-10, -10, 2, 3, 6};
        sorting.sort(test5);
        assertArrayEquals(test5, test5s);
    }
    @Test
    void testSix(){
        int[] test6 = {59, 60, 49, -19, 1, 100, -1000};
        int[] test6s = {-1000, -19, 1, 49, 59, 60, 100};
        sorting.sort(test6);
        assertArrayEquals(test6, test6s);
    }
}