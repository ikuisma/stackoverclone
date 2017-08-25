package wad.stackoverclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.stackoverclone.domain.Account;
import wad.stackoverclone.repository.AccountRepository;
import wad.stackoverclone.service.AccountService;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final AccountService accountService;

    @Autowired
    public SignupController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(@ModelAttribute Account account) {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute Account account, BindingResult result) {
        if (accountService.usernameIsTaken(account)) {
            result.rejectValue("account", "account.error", "Username already taken!");
        }
        if (result.hasErrors()) {
            return "signup";
        }
        accountService.addAccount(account);
        accountService.loginAccount(account);
        return "redirect:/questions";
    }

}
