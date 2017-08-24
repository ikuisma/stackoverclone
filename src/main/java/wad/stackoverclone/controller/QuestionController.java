package wad.stackoverclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.service.QuestionService;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        if (questions.size() == 0) {
            questions = null;
        }
        model.addAttribute("questions", questions);
        return "questions";
    }

}
