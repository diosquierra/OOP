package nsu.oop.priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class JunitTestClassMyPriorityQueue {
    @Test
    void requestedTest(){
        MyPriorityQueue pq = new MyPriorityQueue<Integer, String>();

        pq.insert(200, "dog");
        pq.insert(10, "human");
        pq.extractMaximum();
        pq.insert(5, "penguin");
        pq.insert(1000, "parrot");

        Node myMax = pq.extractMaximum();
        assertEquals(1000, myMax.getKey());
    }

    @Test
    void streamTest(){
        MyPriorityQueue <Integer,String> q = new MyPriorityQueue<>();
        q.insert(10, "Rofler");
        q.insert(19, "Rofle");
        q.insert(20, "Rofl");
        q.insert(30, "Rof");
        assertEquals(4, q.stream().count());
    }
}
