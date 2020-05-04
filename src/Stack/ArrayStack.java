package Stack;

import java.util.ArrayList;

public class ArrayStack<E> implements IStack<E> {
    private final int INITIAL_SIZE;
    private int usedCapacity;
    private E[] stack;


    public ArrayStack(int size){
        usedCapacity = 0;
        INITIAL_SIZE =size;
        stack = (E[]) new Object[INITIAL_SIZE];
    }

    @Override
    public void push(E value) throws FullStackException {
        if(usedCapacity == size()) throw new FullStackException();
        stack[++usedCapacity] = value;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return stack[--usedCapacity];
    }

    @Override
    public E peek() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return stack[usedCapacity-1];
    }

    @Override
    public void clear() {
        usedCapacity = 0;
    }

    @Override
    public int size() {
        return INITIAL_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return usedCapacity==0;
    }
}
