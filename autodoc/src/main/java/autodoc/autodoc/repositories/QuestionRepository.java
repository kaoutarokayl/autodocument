package autodoc.autodoc.repositories;



import autodoc.autodoc.entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
