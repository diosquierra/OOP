package nsu.oop.mystack;

import java.lang.reflect.Array;

/**
 * So it has a private integer variable index which is pointing on the last free space,
 * Array link: arrayStack,
 * Constructor which gets array / gets the size of array,
 * Public method push which gets element and push it,
 * Public method pop which returns the last element in array,
 * Public method count which returns variable index.
 */


public class MyStack <T>{
    private int index = 0;

    public T[] arrayStack;

    public MyStack(T[] arrayStack){
        this.arrayStack = arrayStack;
    }

    public MyStack(int stackSize){
        arrayStack = (T[]) Array.newInstance(Object.class, stackSize);
    }

    public void push(T elem){
        arrayStack[index] = elem;
        index++;
    }

    public T pop(){
        index--;
        return arrayStack[index];
    }

    public int count(){
        return index;
    }
}
