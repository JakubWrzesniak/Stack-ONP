package Stack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinkingStackTest {

    SinkingStack<Integer> stack = new SinkingStack<>(3);

    @Test
    void Test1(){
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3,stack.size());
        stack.push(4);
        assertEquals(3, stack.size());
        assertEquals("4 2 3 ",stack.toString());
        assertEquals(4, stack.peek());
        assertEquals(4,stack.pop());
        assertEquals(2,stack.size());
    }

    @Test
    void exceptions(){
        stack.clear();
        EmptyStackException exception = assertThrows(EmptyStackException.class, ()->{stack.pop();});
        EmptyStackException exception1 = assertThrows(EmptyStackException.class, ()->{stack.peek();});
    }
}