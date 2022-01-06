package xyz.bumbing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PropertiesTest {

    int value = 0;

    @Test
    @Disabled
    void increaseValue1(){
        System.out.println(value);
        value++;
        System.out.println(this);
    }

    @Test
    @Disabled
    void increaseValue2(){
        System.out.println(value);
        value++;
        System.out.println(this);
    }
}
