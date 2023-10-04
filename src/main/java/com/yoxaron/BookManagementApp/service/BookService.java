package com.yoxaron.BookManagementApp.service;

import com.yoxaron.BookManagementApp.model.Book;
import com.yoxaron.BookManagementApp.model.Person;
import com.yoxaron.BookManagementApp.repository.BookRepository;
import com.yoxaron.BookManagementApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;

    @Autowired
    public BookService(BookRepository bookRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        bookRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public Optional<Person> getBookOwner(int id) {
//        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.person_id " +
//                "WHERE Book.book_id = ?", new Object[]{id}, new PersonMapper()).stream().findAny();

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return Optional.ofNullable(book.getPerson());
        } else {
            // Обработка случая, если книга не найдена
            return Optional.empty();
        }
    }

    @Transactional
    public void assign(int id, Person person) {
//        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", person.getId(), id);

        Optional<Book> optionalBook = bookRepository.findById(id);
        Optional<Person> optionalPerson = personRepository.findById(person.getId());

        if (optionalBook.isPresent() && optionalPerson.isPresent()) {
            Book book = optionalBook.get();
            person = optionalPerson.get();

            book.setPerson(person);
            bookRepository.save(book);
        }
    }

    @Transactional
    public void release(int id) {
//        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE book_id=?", id);

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setPerson(null);
            bookRepository.save(book);
        }
    }
}