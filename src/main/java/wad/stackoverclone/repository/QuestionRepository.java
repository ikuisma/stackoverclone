package wad.stackoverclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.stackoverclone.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
}
