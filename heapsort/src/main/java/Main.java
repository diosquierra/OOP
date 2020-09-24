import nsu.oop.heapsort.HeapSort;

public class Main {
    public static void main(String[] args){
        int[] arrayOne = {5, 4, 3, 2, 1};
        HeapSort abc = new HeapSort();
        abc.sort(arrayOne);

        for (int num : arrayOne) {
            System.out.print(num + ", ");
        }

    }
}
