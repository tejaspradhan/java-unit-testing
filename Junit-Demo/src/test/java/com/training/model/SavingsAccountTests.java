package com.training.model;

import com.training.dao.AccountDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class SavingsAccountTests {

    @Mock
    private AccountDAO accountDAO;

    @InjectMocks
    private SavingsAccount savingsAccount;

    @BeforeEach
    void beforeEach(){
        //savingsAccount= new SavingsAccount("Tejas",4000);
    }

    @Test
    void testSavingsAccountConstructor(){
        SavingsAccount savingsAccount = new SavingsAccount("Tejas",4000);
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

    @Test
    void testDepositWithDependencies() {
        //expect that the dependencies are met
        Mockito.when(accountDAO.deposit(anyDouble())).thenReturn(4000d);

        savingsAccount.deposit(4000);

        Assertions.assertTrue(savingsAccount.getBalance() == 4000);

        verify(accountDAO, times(1)).deposit(4000);
    }

}
