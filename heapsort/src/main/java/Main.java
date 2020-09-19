import static org.junit.Assert.assertArrayEquals;

public class Main {
    public static void main(String[] args){

        // In main we are testing our sorting with this tests
        // This is arrays which we should sort
        int[] test1 = {1, 2, 3, 4, 5, 6};
        int[] test2 = {6, 5, 4, 3, 2, 1};
        int[] test3 = {100, 14, 10, -100, 5};
        int[] test4 = {100, 100, 50, 60, 20};
        int[] test5 = {6, 3, 2, - 10, -10};

        // This is the same arrays but sorted
        int[] test1s = {1, 2, 3, 4, 5, 6};
        int[] test2s = {1, 2, 3, 4, 5, 6};
        int[] test3s = {-100, 5, 10, 14, 100};
        int[] test4s = {20, 50, 60, 100, 100};
        int[] test5s = {-10, -10, 2, 3, 6};

        HeapSort sorting = new HeapSort();
        sorting.sort(test1);
        sorting.sort(test2);
        sorting.sort(test3);
        sorting.sort(test4);
        sorting.sort(test5);

        assertArrayEquals(test1, test1s);
        assertArrayEquals(test2, test2s);
        assertArrayEquals(test3, test3s);
        assertArrayEquals(test4, test4s);
        assertArrayEquals(test5, test5s);

    }
}
