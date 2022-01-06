package xyz.bumbing;

import org.junit.jupiter.api.Test;

/**
 *테스트 의존성을 낮추기 위해
 *기본 전략은 테스트 케이스마다 하나의 인스턴스 생성
 */
public class InstanceTest {

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
