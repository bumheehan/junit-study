package xyz.bumbing;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    int value = 0;

    @Test
    @Order(3)
    @DisplayName("increaseValue1")
    void increaseValue1(){
        System.out.println(value);
        value++;
        System.out.println(this);
    }

    @Test
    @Order(2)
    @DisplayName("increaseValue2")
    void increaseValue2(){
        System.out.println(value);
        value++;
        System.out.println(this);
    }
}
