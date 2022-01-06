package xyz.bumbing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudyTest {


    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }
    @Test
    void create1(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create1");
    }
    @Test
    @Disabled
    void create2(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create2");
    }
    //모든 Test코드 이전에 하나
    //static void로만 작성
    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }
    //모든 Test코드 이후에 하나
    //static void로만 작성
    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    //매테스트 이전과 이후에 시
    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }
    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }
}