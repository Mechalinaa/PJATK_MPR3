package org.example.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private Employee emp1;
    private Employee emp2;
    private Employee emp3;

    @BeforeEach
    void setUp() {
        emp1 = new Employee("Jan", "Kowalski", "jan@firma.pl", "FirmaA", Position.PROGRAMISTA);
        emp2 = new Employee("Jan", "Kowalski", "jan@firma.pl", "FirmaA", Position.PROGRAMISTA);
        emp3 = new Employee("Anna", "Nowak", "anna@firma.pl", "FirmaB", Position.MANAGER);
    }

    @Test
    void equalsAndHashCode_basedOnEmail() {
        // Arrange
        Employee e1 = emp1;
        Employee e2 = emp2;
        Employee e3 = emp3;

        // Act & Assert
        assertEquals(e1, e2, "Dwa obiekty z tym samym emailem powinny być równe (equals)");
        assertEquals(e1.hashCode(), e2.hashCode(), "hashCode powinien być zgodny dla tych obiektów");
        assertNotEquals(e1, e3, "Różne emaile -> różne obiekty");
    }

    @Test
    void constructor_setsSalaryFromPosition() {
        // Arrange
        Position position = Position.STAZYSTA;

        // Act
        Employee e = new Employee("Marek", "Nowy", "marek@f.pl", "FirmaX", position);

        // Assert
        assertEquals(position.getSalary(), e.getSalary(), "Konstruktor powinien ustawić salary zgodnie z position");
    }

    @Test
    void setters_validation_shouldThrowOnInvalidInputs() {
        // Arrange
        Employee e = new Employee("Adam", "Kowal", "adam@f.pl", "FirmaZ", Position.PROGRAMISTA);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> e.setName(""), "Puste imię powinno rzucić wyjątek");
        assertThrows(IllegalArgumentException.class, () -> e.setSurname("   "), "Puste nazwisko powinno rzucić wyjątek");
        assertThrows(IllegalArgumentException.class, () -> e.setEmail("invalidEmail"), "Email bez @ powinien rzucić wyjątek");
        assertThrows(IllegalArgumentException.class, () -> e.setCompanyName(""), "Pusta nazwa firmy powinna rzucić wyjątek");
        assertThrows(IllegalArgumentException.class, () -> e.setPosition(null), "Null jako stanowisko -> wyjątek");
        assertThrows(IllegalArgumentException.class, () -> e.setSalary(-1), "Ujemna pensja -> wyjątek");
    }
}
