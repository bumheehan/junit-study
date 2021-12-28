package xyz.bumbing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssumeTest {
    static  {
        System.setProperty("TEST_PROPERTY","LOCAL2");
    }

    @Test
    @DisplayName(" assume 학습 ")
    void assumeStudy(){
        String test_env = System.getProperty("TEST_PROPERTY");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

    }
    @Test
    @DisplayName(" assumingThat 학습 ")
    void assumingThatStudy(){
        String test_env = System.getProperty("TEST_PROPERTY");

        assumingThat("LOCAL1".equalsIgnoreCase(test_env),()->{
            System.out.println("LOCAL1 테스트");
        });

        assumingThat("LOCAL2".equalsIgnoreCase(test_env),()->{
            System.out.println("LOCAL2 테스트");
        });
    }

    //Enabled , Disabled Annotation

    @Test
    @DisplayName("@EnabledIfEnvironmentVariable 학습 ")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV",matches = "LOCAL")
    void studyEnabledEnv(){
        System.out.println("LOCAL 실행");
    }

    @Test
    @DisplayName("@DisabledIfEnvironmentVariable 학습 ")
    @DisabledIfEnvironmentVariable(named = "TEST_ENV",matches = "LOCAL")
    void studyDisabledEnv(){
        System.out.println("LOCAL 실행");
    }
    @Test
    @DisplayName("@EnabledIfSystemProperty 학습 ")
    @EnabledIfSystemProperty(named = "TEST_ENV",matches = "LOCAL1")
    void studyEnabledProperty(){
        System.out.println("LOCAL 실행");
    }

    @Test
    @DisplayName("@DisabledIfSystemProperty 학습 ")
    @DisabledIfSystemProperty(named = "TEST_ENV",matches = "LOCAL1")
    void studyDisabledProperty(){
        System.out.println("LOCAL 실행");
    }



    @Test
    @DisplayName("@EnabledOnOs 학습 ")
    @EnabledOnOs({OS.MAC,OS.LINUX})
    void studyEnabledAno(){
        System.out.println("mac 실행");
    }

    @Test
    @DisplayName("@DisabledOnOs 학습 ")
    @DisabledOnOs({OS.MAC,OS.LINUX})
    void studyDisabledAno(){
        System.out.println("mac 실행");
    }
    @Test
    @DisplayName("@EnabledOnJre 학습 ")
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_11})
    void studyEnabledJreAno(){
        System.out.println("java 11 실행");
    }

    @Test
    @DisplayName("@DisabledOnJre 학습 ")
    @DisabledOnJre(JRE.JAVA_11)
    void studyDisabledJreAno(){
        System.out.println("java 11 실행");
    }


}