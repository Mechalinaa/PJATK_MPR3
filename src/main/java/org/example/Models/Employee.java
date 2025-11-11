package org.example.Models;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Employee {
    private String name;
    private String surname;
    private String email; //unique id
    private String companyName;
    private Position position;
    private int salary;
//    Validation validator = new Validation();

    public void setName(String name) {
        if (!Validation.isStringValid(name)) {
            throw new IllegalArgumentException("Puste imie");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (!Validation.isStringValid(surname)) {
            throw new IllegalArgumentException("Puste nazwisko");
        }
        this.surname = surname;
    }

    public void setEmail(String email) {
        if (!Validation.isStringValid(email)) {
            throw new IllegalArgumentException("Pusty email");
        }
        if (!Validation.isEmailValid(email)) {
            throw new IllegalArgumentException("Niepoprawny format maila - bez @");
        }
        this.email = email;
    }

    public void setCompanyName(String companyName) {
        if (!Validation.isStringValid(companyName)) {
            throw new IllegalArgumentException("Niepoprawna nazwa firmy");
        }
        this.companyName = companyName;
    }

    public void setPosition(Position position) {
        if (!Validation.isPositionValid(position)) {
            throw new IllegalArgumentException("Nie ma takiego stanowiska w firmie");
        }
        this.position = position;
    }

    public void setSalary(int salary) {
        if (!Validation.isSalaryValid(salary)) {
            throw new IllegalArgumentException("Pensja nie może być ujemna");
        }
        this.salary = salary;
    }
}
