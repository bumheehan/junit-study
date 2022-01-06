package xyz.bumbing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    @Test
    void test1(){

        assertAll(
                ()->{assertEquals("a","a");},
                ()->{assertEquals("b","b");},
                ()->{assertEquals("c","c");},
                ()->{assertEquals("d","e");}
        );
    }
    @Test
    void test2(){

        assertAll(
                ()->{assertEquals("a","a");},
                ()->{assertEquals("b","b");},
                ()->{assertEquals("c","c");},
                ()->{assertEquals("e","e");}
        );
    }
}
