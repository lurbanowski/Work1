package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Document;

import java.util.List;


public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findFirstByIdOrderByPath(String id);

}
