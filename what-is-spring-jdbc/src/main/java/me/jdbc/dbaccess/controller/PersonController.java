package me.jdbc.dbaccess.controller;


import lombok.RequiredArgsConstructor;
import me.jdbc.dbaccess.dto.Person;
import me.jdbc.dbaccess.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

//RESTFUL한 구조로 만드는 방법을 알려드릴게요!
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    //숙제로 해야함
    //read person
    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Integer id){
        /**
         *
         */
        return new Person();
    }

    @PostMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person){
        Person createdPerson = personService.createPerson(person);
        return createdPerson;
    }

}
