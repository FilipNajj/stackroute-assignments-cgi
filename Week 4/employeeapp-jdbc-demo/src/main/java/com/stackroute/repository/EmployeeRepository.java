package com.stackroute.repository;

import com.stackroute.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployee() throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;
    boolean addEmployee(Employee employee) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    boolean deleteEmployee(Employee employee) throws SQLException;
}
