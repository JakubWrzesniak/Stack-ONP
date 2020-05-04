package Stack;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.FunctionUtils;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    ArrayStack<Integer> stos = new ArrayStack<>(2);

    @Test
    void push() {
        stos.push(5);
        stos.push(7);
        assertFalse(stos.isEmpty());
        assertEquals(2,stos.size());
        assertEquals(7,stos.pop());
        assertEquals(5,stos.peek());
        assertEquals(5,stos.pop());
        assertTrue(stos.isEmpty());
    }

    @Test
    void exceptions(){
        EmptyStackException exception =  assertThrows(EmptyStackException.class, ()->{stos.pop();});
        stos.push(1);
        stos.push(1);
        FullStackException exception1 = assertThrows(FullStackException.class,()->{stos.push(1);});
    }
}