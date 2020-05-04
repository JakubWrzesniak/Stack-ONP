package Stack;

public class ListStack<E> implements IStack<E> {

    private Element head;
    private int size;

    class Element<E>{

        private E value;
        private Element nextElem;

        Element(E value){
            this.value=value;
            nextElem = null;
        }

        public E getValue() {
            return value;
        }

        public Element getNextElem() {
            return nextElem;
        }

        public void setNextElem(Element nextElem) {
            this.nextElem = nextElem;
        }

        @Override
        public String toString() {
            return value+" ";
        }
    }

    @Override
    public void push(E value) throws FullStackException {
        Element e = new Element<E>(value);
        e.setNextElem(head);
        head = e;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        Element e = head;
        head = head.getNextElem();
        size--;
        return (E) e.getValue();
    }

    @Override
    public E peek() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return (E)head.getValue();
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        Element e = head;
        while (e!=null){
            s.append(e.toString());
            e = e.getNextElem();
        }
        return s.toString();
    }
}
