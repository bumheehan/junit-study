package xyz.bumbing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import xyz.bumbing.annotation.SlowTest;
import xyz.bumbing.extension.FindSlowTestExtension;
import xyz.bumbing.extension.FindSlowTestExtension2;


@ExtendWith(FindSlowTestExtension.class)//기본생성자로 생성된 확장팩
public class ExtensionTest {

    //직접 확장팩을 선언하여 사용용
   @RegisterExtension
    static FindSlowTestExtension2 findSlowTestExtension2 = new FindSlowTestExtension2(300L);

    @Test
    @DisplayName("slow test1")
    void slowTest1() throws InterruptedException {
        Thread.sleep(500);
    }
    @Test
    @DisplayName("slow test2")
    void slowTest2() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @SlowTest
    @DisplayName("slow test3")
    void slowTest3() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test
    @DisplayName("slow test4")
    void slowTest4() throws InterruptedException {
        Thread.sleep(3000);
    }

}
