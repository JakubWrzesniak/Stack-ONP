package Stack;

public class SinkingStack<E> implements IStack<E>{

    private final int INITIAL_SIZE;
    private int usedCapacity;
    private E[] stack;
    private int top;
    private int bottom;

    SinkingStack(int INITIAL_SIZE){
        this.INITIAL_SIZE = INITIAL_SIZE;
        stack = (E[]) new Object[INITIAL_SIZE];
        usedCapacity = 0;
        top = -1 ;
        bottom = 0;
    }

    @Override
    public void push(E value) throws FullStackException {
        if(usedCapacity == INITIAL_SIZE){
            top = bottom;
            stack[top] = value;
            bottom = (bottom+1)%INITIAL_SIZE;
        }else{
            top = (top+1)%INITIAL_SIZE;
            stack[top] = value;
            usedCapacity++;
        }
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        E e = stack[top--];
        usedCapacity--;
        top = ((top-1)+INITIAL_SIZE)%INITIAL_SIZE;
        return e;
    }

    @Override
    public E peek() throws EmptyStackException {
        if(isEmpty()) throw  new EmptyStackException();
        return stack[top];
    }

    @Override
    public void clear() {
        top =-1;
        bottom =0;
        usedCapacity =0;
    }

    @Override
    public int size() {
        return usedCapacity;
    }

    @Override
    public boolean isEmpty() {
        return usedCapacity==0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int pos = top;
        for(int i =0 ; i < INITIAL_SIZE ;i++){
            sb.append(stack[pos]+" ");
            pos = (pos+1)%INITIAL_SIZE;
        }
        return sb.toString();
    }
}
