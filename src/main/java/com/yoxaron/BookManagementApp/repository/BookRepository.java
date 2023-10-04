package com.yoxaron.BookManagementApp.repository;

import com.yoxaron.BookManagementApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}