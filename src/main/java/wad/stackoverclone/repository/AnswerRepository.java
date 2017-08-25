package wad.stackoverclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.stackoverclone.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{
}
