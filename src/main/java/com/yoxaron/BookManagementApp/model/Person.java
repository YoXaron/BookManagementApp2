package com.yoxaron.BookManagementApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    @NotEmpty(message="Name shouldn't be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String fullName;

    @Column(name = "birth_year")
    @Min(value = 1900, message = "Age should be greater than 1900")
    @Max(value = 2015, message = "Age should be less than 2015")
    private int birthYear;

    @OneToMany(mappedBy = "person")
    private List<Book> books;

    public Person(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }
}
