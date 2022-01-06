package xyz.bumbing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import xyz.bumbing.annotation.FastTest;
import xyz.bumbing.annotation.SlowTest;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

//./mv
class TagTest {

    @Test
    @DisplayName("테스트 fast1")
    @Tag("fast")
    void fast1(){
        System.out.println("fast1");
    }
    @Test
    @DisplayName("테스트 fast2")
    @Tag("fast")
    void fast2(){
        System.out.println("fast2");
    }
    @Test
    @DisplayName("테스트 slow1")
    @Tag("slow")
    void slow1(){
        System.out.println("slow1");
    }
    @Test
    @DisplayName("테스트 slow2")
    @Tag("slow")
    void slow2(){
        System.out.println("slow2");
    }

    //custom annotation

    @DisplayName("테스트 fast3")
    @FastTest
    void fast3(){
        System.out.println("fast3");
    }
    @DisplayName("테스트 slow1")
    @SlowTest
    void slow3(){
        System.out.println("slow3");
    }
}