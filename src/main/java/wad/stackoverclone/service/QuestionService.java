package wad.stackoverclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.repository.QuestionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AccountService accountService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, AccountService accountService) {
        this.questionRepository = questionRepository;
        this.accountService = accountService;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Transactional
    public void postNewQuestion(Question question) {
        question = this.questionRepository.save(question);
        question.setAuthor(accountService.currentAccount());
    }

}
