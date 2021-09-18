package me.jdbc.dbaccess.service;

import lombok.RequiredArgsConstructor;
import me.jdbc.dbaccess.dto.Person;
import me.jdbc.dbaccess.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Spring 5 이상에서부터,
 * Spring boot 2.xx  부터는
 *
 * 생성자 주입을 할 때,
 *
 * @Autowired를 생략할 수 있다.
 *
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public Person createPerson(Person person) {
        Person createdPerson = personRepository.createPerson(person);

        return createdPerson;
    }
}
