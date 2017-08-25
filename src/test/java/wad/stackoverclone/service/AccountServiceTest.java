package wad.stackoverclone.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wad.stackoverclone.domain.Account;
import wad.stackoverclone.repository.AccountRepository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void savedAccountShouldBeInDatabase() {
        Account a = new Account();
        a.setPassword("password1");
        a.setUsername("username1");
        accountService.addAccount(a);
        assertNotNull(accountRepository.findAccountByUsername(a.getUsername()));
    }

    @Test
    public void accountIsTakenShouldReturnTrueForAddedUsername() {
        Account a = new Account();
        a.setPassword("password2");
        a.setUsername("username2");
        accountService.addAccount(a);
        assertTrue(accountService.usernameIsTaken(a));
    }


}
