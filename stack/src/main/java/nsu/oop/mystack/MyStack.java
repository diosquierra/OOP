package nsu.oop.mystack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * So it has a private integer variable index which is pointing on the last free space,
 * Array link: arrayStack,
 * Constructor which gets array / gets the size of array / nothing (in this way stack's size will be 20),
 * Public method push which gets element and push it,
 * Public method pop which returns the last element in array or exception if stack is empty,
 * Public method count which returns variable index.
 */


public class MyStack<T> implements Iterable<T>, Iterator<T> {
    private int index = 0;
    private int stackSize;

    public T[] arrayStack;

    private void resize(){
        arrayStack = Arrays.copyOf(arrayStack, arrayStack.length + 20);
        stackSize += 20;
    }

    public MyStack(){
        this.arrayStack = (T[]) new Object[20];
    }

    public MyStack(T[] arrayStack){
        this.arrayStack = arrayStack;
        this.stackSize = arrayStack.length;
    }

    public MyStack(int stackSize){
        arrayStack = (T[]) new Object[stackSize];
        this.stackSize = stackSize;
    }

    public void push(T elem){
        if(stackSize - 1 == index){
            this.resize();
        }
        arrayStack[index] = elem;
        index++;
    }

    public T pop(){
        if(index == 0){
            throw new NoSuchElementException("Stack is empty");
        }
        index--;
        return arrayStack[index];
    }

    public int count(){
        return index;
    }

    @Override
    public boolean hasNext(){
        if(index == 0){
            return false;
        }
        return true;
    }

    @Override
    public T next(){
        if(hasNext() == false){
            throw new NoSuchElementException("Stack is empty");
        }
        return pop();
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
}
