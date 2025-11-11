package org.example.Service;

import org.example.Models.Employee;
import org.example.Models.Position;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class EmployeeService {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        for (Employee emp : employeeList) {
            if (emp.getEmail().equals(employee.getEmail())) {
                throw new IllegalArgumentException("Pracownik z tym emailem juz istnieje");
            }
        }
        employeeList.add(employee);
    }

    public void showEmployees() {
        for (Employee emp : employeeList) {
            System.out.println(emp + "\n");
        }
    }

    public void searchByCompanyName(String companyName) {
        for (Employee emp : employeeList) {
            if (emp.getCompanyName().equals(companyName)) {
                System.out.println(emp.getName() + " " + emp.getSurname() + "\n");
            }
        }
    }

    public void sortInAlphabeticalOrder() {
        Comparator<Employee> surnameComparator = new Comparator<>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getSurname().compareToIgnoreCase(emp2.getSurname());
            }
        };
        employeeList.sort(surnameComparator);
        for (Employee emp : employeeList) {
            System.out.println(emp.getName() + " " + emp.getSurname() + "\n");
        }
    }

    public HashMap<Position, ArrayList<Employee>> groupByPosition() {
        HashMap<Position, ArrayList<Employee>> groupedByPosition = new HashMap<>();
        for (Position pos : Position.values()) {
            groupedByPosition.put(pos, new ArrayList<>());
        }

        for (Employee emp : employeeList) {
            Position position = emp.getPosition();
            groupedByPosition.get(position).add(emp);

        }
        return groupedByPosition;
    }

    public HashMap<Position, Integer> countEmployees() {
        HashMap<Position, Integer> countedEmployees = new HashMap<>();
        for (Position pos : Position.values()) {
            countedEmployees.put(pos, 0);
        }
        for (Employee emp : employeeList) {
            Position position = emp.getPosition();
            countedEmployees.put(position, countedEmployees.get(position) + 1);
        }
        return countedEmployees;

    }

    public double salaryStatistic() {
        double allSalaries = 0;
        double numberOfEmployees = 0;
        for (Employee emp : employeeList) {
            allSalaries += emp.getSalary();
            numberOfEmployees += 1;
        }
        return allSalaries / numberOfEmployees; //zwracamy srednia wynagrodzen
    }

    public Employee bestPaid() {
        if (employeeList.isEmpty()) {
            return null;
        }
        Employee bestPaid = employeeList.getFirst(); //.get(0) - przypisujemy pierwszy element z listy pracownikow
        for (Employee emp : employeeList) {
            if (bestPaid.getSalary() < emp.getSalary()) {
                bestPaid = emp;
            }
        }
        return bestPaid;
    }
}

