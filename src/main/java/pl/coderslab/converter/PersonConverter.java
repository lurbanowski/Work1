package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Person;
import pl.coderslab.repository.PersonRepository;

public class PersonConverter implements Converter<String, Person> {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person convert(String s) { return personRepository.findOne(Long.parseLong(s));
    }
}
