package wad.stackoverclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.stackoverclone.domain.Answer;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.repository.QuestionRepository;
import wad.stackoverclone.service.QuestionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionService questionService, QuestionRepository questionRepository) {
        this.questionService = questionService;
        this.questionRepository  = questionRepository;
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

    @RequestMapping(value="/questions/{id}", method = RequestMethod.GET)
    public String getQuestion(@PathVariable Long id, Model model, @ModelAttribute Answer answer) {
        model.addAttribute("question", questionRepository.findOne(id));
        return "question";
    }

    @RequestMapping(value="/questions/{id}/answers", method = RequestMethod.POST)
    public String postAnswer(
            @PathVariable Long id,
            Model model,
            @Valid @ModelAttribute Answer answer,
            BindingResult result) {
        model.addAttribute("question", questionRepository.findOne(id));
        if (result.hasErrors()) {
            return "question";
        }
        questionService.postNewAnswer(answer, id);
        return "redirect:/questions/" + id;
    }

}
