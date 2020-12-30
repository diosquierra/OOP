package nsu.oop.priorityqueue;

/**
 * This is structure for binary heap
 * @param <Key> - key type
 * @param <Value> - value type
 */
public class Node<Key extends Comparable<Key>, Value> {
    private Key key;
    private Value value;

    public Node(Key newKey, Value newValue) {
        key = newKey;
        value = newValue;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }
}
