package wad.stackoverclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wad.stackoverclone.domain.Account;
import org.springframework.security.core.userdetails.User;
import wad.stackoverclone.repository.AccountRepository;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public CustomUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account a = accountRepository.findAccountByUsername(s);
        if (a == null) {
            throw new UsernameNotFoundException("No user with username: " + s);
        }
        return new User(
                a.getUsername(),
                a.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER"))
        );
    }



}
