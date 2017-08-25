package wad.stackoverclone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import wad.stackoverclone.domain.Question;
import wad.stackoverclone.repository.QuestionRepository;

import javax.annotation.PostConstruct;

@Configuration
@Profile("development")
public class DevelopmentProfile {

    @Autowired
    private QuestionRepository questionRepository;

    @PostConstruct
    public void init() {
        questionRepository.save(QuestionCreator.zappaQuestion());
        questionRepository.save(QuestionCreator.pandarusQuestion());
        questionRepository.save(QuestionCreator.zappaQuestion());
        questionRepository.save(QuestionCreator.pandarusQuestion());
        questionRepository.save(QuestionCreator.zappaQuestion());
        questionRepository.save(QuestionCreator.pandarusQuestion());
    }

}

class QuestionCreator {

    public static Question zappaQuestion() {
        Question q = new Question();
        q.setTitle("Why does it hurt when I pee?");
        q.setContent(
                "Why does it hurt when I pee?\n" +
                        "Why does it hurt when I pee?\n" +
                        "I don't want no doctor,\n" +
                        "To stick no needle in me.\n" +
                        "Why does it hurt when I pee?\n" +
                        "I got it from my toilet seat.\n" +
                        "I got it from my toilet seat.\n" +
                        "It jumped right up,\n" +
                        "And grabbed my meat.\n" +
                        "I got it from my toilet seat.\n" +
                        "Aaaaaaaaaaaahhhh.\n" +
                        "Woooooaaaaaaaaaaaah.\n" +
                        "My balls feel like a pair of maracas.\n" +
                        "My balls feel like a pair of maracas.\n" +
                        "Oh god. I probably got,\n" +
                        "The ghono,ca,ca,ca,cas.\n" +
                        "My balls feel like a pair of maracas.\n" +
                        "Ay, Ay, Ay.\n" +
                        "Why does it,\n" +
                        "Why does it,\n" +
                        "Why does it,\n" +
                        "Why does it,\n" +
                        "Hurt!\n" +
                        "When!\n" +
                        "I!\n" +
                        "Peeeeeeeee!"
        );
        return q;
    }

    public static Question pandarusQuestion() {
        Question q = new Question();
        q.setTitle("Is love a generation of vipers?");
        q.setContent("Is this the generation of love? hot blood, hot\n" +
                "thoughts, and hot deeds? Why, they are vipers:\n" +
                "is love a generation of vipers? Sweet lord, who's\n" +
                "a-field to-day?");
        return q;
    }

}
