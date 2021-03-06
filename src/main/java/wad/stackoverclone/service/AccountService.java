package wad.stackoverclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import wad.stackoverclone.domain.Account;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.repository.AccountRepository;

import javax.transaction.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public AccountService(
            AccountRepository accountRepository,
            PasswordEncoder passwordEncoder,
            CustomUserDetailsService customUserDetailsService
    ) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PreAuthorize("isAuthenticated()")
    public Account addAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @PreAuthorize("isAuthenticated()")
    public boolean usernameIsTaken(Account account) {
        return (accountRepository.findAccountByUsername(account.getUsername()) != null);
    }

    @Transactional
    @PreAuthorize("isAuthenticated()")
    public void addQuestion(Question q) {
        Account a = currentAccount();
        a.getQuestions().add(q);
        accountRepository.save(a);
    }

    @PreAuthorize("isAuthenticated()")
    public Account currentAccount() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                return null;
            }
            return accountRepository.findAccountByUsername(authentication.getName());
    }

    public void loginAccount(Account account) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(account.getUsername());
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

}
