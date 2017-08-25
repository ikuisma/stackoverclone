package wad.stackoverclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.service.QuestionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String get(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        if (questions.size() == 0) {
            questions = null;
        }
        model.addAttribute("questions", questions);
        return "questions";
    }

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public String post(@Valid @ModelAttribute Question question, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask";
        }
        questionService.postNewQuestion(question);
        return "redirect:/questions";
    }

    @RequestMapping(value="/ask", method = RequestMethod.GET)
    public String getCreationForm(@ModelAttribute Question question) {
        return "ask";
    }

}
