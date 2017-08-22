package wad.stackoverclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "StackOverClone -- coming soon to stores near you!";
    }


}
