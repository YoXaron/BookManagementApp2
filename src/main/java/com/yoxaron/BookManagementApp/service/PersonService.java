package com.yoxaron.BookManagementApp.service;

import com.yoxaron.BookManagementApp.model.Book;
import com.yoxaron.BookManagementApp.model.Person;
import com.yoxaron.BookManagementApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }

//    public Optional<Person> show(String fullName) {
//
//    }

    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return personRepository.getPersonByFullName(fullName);
    }

    public List<Book> getBooksByPersonId(int id) {
        return personRepository.findBooksByPersonId(id);
    }
}
