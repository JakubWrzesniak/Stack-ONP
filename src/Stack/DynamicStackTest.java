package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicStackTest {

    DynamicStack<Integer> stack = new DynamicStack<>(3);

    @Test
    void Test1(){
        stack.push(1);
        assertEquals(3,stack.size());
        stack.push(3);
        assertEquals(3,stack.size());
        stack.push(5);
        assertEquals(6,stack.size());
        stack.push(7);
        assertEquals(6,stack.size());
        stack.push(9);
        assertEquals(12,stack.size());
        assertEquals(9,stack.pop());
        assertEquals(12,stack.size());
        assertEquals(7,stack.pop());
        assertEquals(5,stack.pop());
        assertEquals(6,stack.size());
        assertEquals(3,stack.pop());
        assertEquals(3,stack.size());
        assertEquals(1,stack.pop());
    }
}