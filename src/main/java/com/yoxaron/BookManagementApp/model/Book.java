package com.yoxaron.BookManagementApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message="Title shouldn't be empty")
    @Size(min = 2, max = 50, message = "Title should be between 2 and 50 characters")
    private String name;

    @Column(name = "author")
    @NotEmpty(message="Author`s name shouldn't be empty")
    @Size(min = 2, max = 50, message = "Author`s name should be between 2 and 50 characters")
    private String author;

    @Column(name = "year")
    @Min(value = 1500, message = "Year of publishing should be greater than 1500")
    @Max(value = 2023, message = "Year of publishing should be less than 2023")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
}
