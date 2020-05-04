package Stack;

public interface IStack <E> {
    void push(E value) throws FullStackException;
    E pop() throws EmptyStackException; //zwraca i usuwa
    E peek() throws EmptyStackException; // tylko zwraca
    void clear();
    int size();
    boolean isEmpty();
}
