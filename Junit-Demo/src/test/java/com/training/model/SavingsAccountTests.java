package com.training.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTests {
    SavingsAccount savingsAccount;

    @BeforeEach
    void beforeEach(){
        savingsAccount= new SavingsAccount("Tejas",4000);
    }

    @Test
    void testSavingsAccountConstructor(){
        Assertions.assertNotNull(savingsAccount);
    }

    @Test
    void testGetName(){
        Assertions.assertEquals("Tejas",savingsAccount.getName());
    }

    @Test
    void testCheckBalance(){
        Assertions.assertEquals(4000,savingsAccount.getBalance());
    }

    @Test
    void withDrawPositiveTest(){

        Assertions.assertDoesNotThrow(()->{
            double amount = savingsAccount.withdraw(3000);
            Assertions.assertEquals(3000,amount);
        });
        Assertions.assertEquals(1000, savingsAccount.getBalance());
    }

    @Test
    void withDrawNegativeTest(){
        Assertions.assertThrows(InsufficientBalanceException.class,()->{
            double amount = savingsAccount.withdraw(5000);
        });
    }

    @Test
    void depositTest(){
        savingsAccount.deposit(4000);
        Assertions.assertEquals(8000,savingsAccount.getBalance());
    }
}
