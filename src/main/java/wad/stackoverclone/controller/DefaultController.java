package wad.stackoverclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("*")
    public String redirect() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

}
