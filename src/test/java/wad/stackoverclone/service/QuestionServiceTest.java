package wad.stackoverclone.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionRepository questionRepository;

    @Before
    public void setUp() {
        Question q = new Question();
        q.setContent("Test content");
        q.setTitle("Test title");
        questionRepository.save(q);
    }

    @Test
    public void findAllQuestionsShouldContainQuestionWithAddedTitle() {
        List<String> titles = questionService.getAllQuestions().stream()
                .map(Question::getTitle)
                .collect(Collectors.toList());
        assertTrue(titles.contains("Test title"));
    }

}
