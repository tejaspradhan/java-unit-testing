package com.training.model;

import org.junit.jupiter.api.*;

public class UserTest {

    @BeforeEach
    void beforeEach(){
        System.out.println("I am called before each method");
    }

    @AfterEach
    void afterEach(){
        System.out.println("I am called after each method");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("I am called before all test cases");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("I am called after all test cases");
    }

    @Test
    void  testConstructor() {
        //execute
        User user = new User(12, "Ramesh", 18);
        //assert the behaviour
        Assertions.assertNotNull(user);
        Assertions.assertEquals(12, user.getId());
        Assertions.assertEquals("Ramesh", user.getName());
        Assertions.assertEquals(18, user.getAge());
    }

    @Test
    void testAgeSetter(){
        User user = new User(12, "Ramesh", 18);
        user.setAge(35);
        Assertions.assertEquals(35,user.getAge());
    }

    @Test
    void testIdSetter(){
        User user = new User(12, "Ramesh", 18);
        user.setId(1);
        Assertions.assertEquals(1,user.getId());
    }

    @Test
    void testNameSetter(){
        User user = new User(12, "Ramesh", 18);
        user.setName("Chetan");
        Assertions.assertEquals("Chetan",user.getName());
    }
}

