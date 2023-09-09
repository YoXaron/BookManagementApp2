package com.yoxaron.BookManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int id;
    private int personId;

    @NotEmpty(message="Title shouldn't be empty")
    @Size(min = 2, max = 50, message = "Title should be between 2 and 50 characters")
    private String name;

    @NotEmpty(message="Author`s name shouldn't be empty")
    @Size(min = 2, max = 50, message = "Author`s name should be between 2 and 50 characters")
    private String author;

    @Min(value = 1500, message = "Year of publishing should be greater than 1500")
    @Max(value = 2023, message = "Year of publishing should be less than 2023")
    private int year;
}
