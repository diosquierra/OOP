package nsu.oop.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This is PriorityQueue based on binary heap.
 * @param <Key> - key type
 * @param <Value> - value type
 */
public class MyPriorityQueue<Key extends Comparable<Key>, Value> implements Iterable <Node<Key, Value>>{
    public Node<Key, Value>[] biHeap;
    private final Comparator<? super Key> comparator;
    private int heapSize = 0;
    private int biHeapArraySize = 0;

    /**
     * Constructor with custom comparator.
     * @param newComparator - comparator
     */
    public MyPriorityQueue(Comparator<? super Key> newComparator){
        this.biHeap = new Node[20];
        comparator = newComparator;
    }

    /**
     * Constructor with naturalOrder comparator.
     */
    public MyPriorityQueue(){
        this.biHeap = new Node[20];
        comparator = Comparator.naturalOrder();
    }

    /**
     * resize is private method which is resizing biHeap.
     */
    private void resize(){
        biHeap = Arrays.copyOf(biHeap, biHeap.length + 20);
        biHeapArraySize += 20;
    }

    /**
     * insert is public method which insert pair (Key, Value) in binary heap.
     * @param key - key.
     * @param value - value.
     */
    public void insert(Key key, Value value){
        if(biHeapArraySize - 1 == heapSize){
            resize();
        }
        biHeap[heapSize++] = new Node(key, value);
        int i = heapSize - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && comparator.compare(biHeap[parent].getKey(), biHeap[i].getKey()) > 0) {
            Node temp = biHeap[i];
            biHeap[i] = biHeap[parent];
            biHeap[parent] = temp;
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    /**
     * extractMaximum is public method which is extracting pair (key, value) with the biggest key.
     * @return Node structure (key, value).
     */
    public Node<Key, Value> extractMaximum(){
        Node returnValue = biHeap[--heapSize];
        biHeap[heapSize] = null;
        return returnValue;
    }

    class MyQueueIterator<T> implements Iterator<T> {
        @Override
        public boolean hasNext() {
        if (heapSize == 0) {
            return false;
        }
        return true;
        }

        @Override
        public T next() {
        if (hasNext() == false) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (T) extractMaximum();
            }
    }
    @Override
    public Iterator<Node<Key,Value>> iterator() {
        return new MyQueueIterator<>();
    }

    class MyPriorityQueueSpliterator implements Spliterator<Node> {
        private int firstPosition;
        private int lastPosition;

        public MyPriorityQueueSpliterator() {
            firstPosition = 0;
            lastPosition = heapSize;
        }

        public MyPriorityQueueSpliterator(int f, int l) {
            firstPosition = f;
            lastPosition = l;
        }
        @Override
        public boolean tryAdvance(Consumer action) {
            if (firstPosition <= lastPosition) {
                firstPosition++;
                action.accept(biHeap[firstPosition]);
            }

            return false;
        }


        @Override
        public Spliterator trySplit() {
            int half = (lastPosition - firstPosition) / 2;

            if (half <= 1) {
                return null;
            }

            int f = firstPosition;
            int l = firstPosition + half;

            firstPosition = l + 1;

            return new MyPriorityQueueSpliterator(f, l);
        }

        @Override
        public long estimateSize() {
            return lastPosition - firstPosition;
        }

        @Override
        public int characteristics() {
            return SIZED;
        }
    }
    Stream<Node> stream() {
        return StreamSupport.stream(new MyPriorityQueueSpliterator(), false);
    }

}
