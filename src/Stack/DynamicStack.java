package Stack;

public class DynamicStack<E> implements IStack<E> {
    private E[] stack;
    private int INITIAL_SIZIE;
    private int usedCapacity;
    private int size;

    DynamicStack(int INITIAL_SIZE){
        size = INITIAL_SIZE;
        this.INITIAL_SIZIE = INITIAL_SIZE;
        clear();
    }

    @Override
    public void push(E value) throws FullStackException {
        stack[usedCapacity++] = value;
        if(4*usedCapacity >= 3*size)
            changeCapacity(true);
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        E e = stack[--usedCapacity];
        if(4*usedCapacity<=size)
            changeCapacity(false);
        return e;
    }

    @Override
    public E peek() throws EmptyStackException {
        return stack[usedCapacity];
    }

    @Override
    public void clear() {
        usedCapacity=0;
        stack = (E[]) new Object[INITIAL_SIZIE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return usedCapacity==0;
    }

    public void changeCapacity(boolean toSmall){
        Object[] temp;
        if(toSmall)
            temp = new Object[2 * this.size()];
        else
            temp = new Object[this.size()/2];

        System.arraycopy(stack, 0, temp, 0, usedCapacity);
        stack = (E[]) temp;
        size = stack.length;
    }
}
