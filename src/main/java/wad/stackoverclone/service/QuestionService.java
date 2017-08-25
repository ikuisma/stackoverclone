package wad.stackoverclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import wad.stackoverclone.domain.Answer;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.repository.AnswerRepository;
import wad.stackoverclone.repository.QuestionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AccountService accountService;
    private final AnswerRepository answerRepository;

    @Autowired
    public QuestionService(
            QuestionRepository questionRepository,
            AccountService accountService,
            AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.accountService = accountService;
        this.answerRepository = answerRepository;
    }

    @PreAuthorize("isAuthenticated()")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Transactional
    @PreAuthorize("isAuthenticated()")
    public void postNewQuestion(Question question) {
        question = this.questionRepository.save(question);
        question.setAuthor(accountService.currentAccount());
    }

    @Transactional
    @PreAuthorize("isAuthenticated()")
    public void postNewAnswer(Answer answer, Long questionId) {
        Question q = questionRepository.findOne(questionId);
        answer.setAuthor(accountService.currentAccount());
        answer.setQuestion(q);
        answerRepository.save(answer);
    }


}
