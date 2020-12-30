package nsu.oop.priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}