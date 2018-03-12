package com.asorokin;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String department;
    private int salary;

    // список подчиненных
    private List<Employee> subordinates;

    // конструктор
    public Employee(String name, String department, int sal) {
        this.name = name;
        this.department = department;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String toString() {
        return ("Employee :[ Name : " + name + ", department : " + department + ", salary :" + salary + " ]");
    }
}
