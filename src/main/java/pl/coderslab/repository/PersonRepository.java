package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
