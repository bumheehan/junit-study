package xyz.bumbing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * 단일 인스턴스로 테스트 실행
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SingleInstanceTest {

    int value = 0;

    @Test
    void increaseValue1(){
        System.out.println(value);
        value++;
        System.out.println(this);
    }

    @Test
    void increaseValue2(){
        System.out.println(value);
        value++;
        System.out.println(this);
    }
}
