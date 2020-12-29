package nsu.oop.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<Key extends Comparable<Key>, Value> implements Iterable <Node<Key, Value>>{
    public Node<Key, Value>[] biHeap;
    private final Comparator<? super Key> comparator;
    private int heapSize = 0;
    private int biHeapArraySize = 0;

    public MyPriorityQueue(Comparator<? super Key> newComparator){
        this.biHeap = new Node[20];
        comparator = newComparator;
    }
    public MyPriorityQueue(){
        this.biHeap = new Node[20];
        comparator = Comparator.naturalOrder();
    }

    private void resize(){
        biHeap = Arrays.copyOf(biHeap, biHeap.length + 20);
        biHeapArraySize += 20;
    }

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
}
