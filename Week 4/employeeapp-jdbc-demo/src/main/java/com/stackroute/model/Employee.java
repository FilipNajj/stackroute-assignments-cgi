package com.stackroute.model;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String city;
    private int salary;

    public Employee(int employeeId, String employeeName, String city, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.city = city;
        this.salary = salary;
    }

    public Employee(){}

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}

//emp_id -- employeeId
//varchar -- String

//object - relation mismatch impedence
