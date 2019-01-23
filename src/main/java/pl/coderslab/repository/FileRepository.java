package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.File;

public interface FileRepository extends JpaRepository<File, Long> {
}
