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
public class Person {

    private int id;

    @NotEmpty(message="Name shouldn't be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String fullName;

    @Min(value = 1900, message = "Age should be greater than 1900")
    @Max(value = 2015, message = "Age should be less than 2015")
    private int birthYear;
}
