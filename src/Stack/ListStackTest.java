package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {
    ListStack<Integer> stack = new ListStack<>();

    @Test
    void Test1(){
        assertTrue(stack.isEmpty());
        stack.push(5);
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(2);
        assertEquals(5,stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("2 3 7 4 5 ",stack.toString());
        assertEquals(2,stack.pop());
        assertEquals(3,stack.peek());
        assertEquals(3,stack.pop());
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    void Exceptions(){
        EmptyStackException exception =  assertThrows(EmptyStackException.class, ()->{stack.pop();});
        EmptyStackException exception1 =  assertThrows(EmptyStackException.class, ()->{stack.peek();});
    }
}