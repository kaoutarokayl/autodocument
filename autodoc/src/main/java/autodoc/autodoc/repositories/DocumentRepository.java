package autodoc.autodoc.repositories;



import autodoc.autodoc.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
