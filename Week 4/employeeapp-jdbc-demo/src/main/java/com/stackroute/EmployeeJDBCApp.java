package com.stackroute;

import com.stackroute.model.Employee;
import com.stackroute.repository.EmployeeRepository;
import com.stackroute.repository.EmployeeRepositoryImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class EmployeeJDBCApp
{
    public static void main( String[] args ){
        System.out.println( "Employee App" );
        System.out.println("=====================");
        System.out.println("Choose an option");
        System.out.println("1. List all the Employee");
        System.out.println("2. Add a new Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Get Employee by Id");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        String url = "jdbc:mysql://localhost:3306/cgicanadadb";
        String userName = "cgicanadauser";
        String password = "Pass@123";
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(url,userName,password);
        switch (option){
            case 1:
                List<Employee> employees = null;
                try {
                    employees = employeeRepository.getAllEmployee();
                } catch (SQLException e) {
                    System.out.println("Failed to read the Employees from the database");
                }
                for (Employee employee: employees){
                    System.out.println(employee);
                }
                break;
            case 2:
                System.out.println("Enter the details(ID, Name, City and salary) of the new Employee:");
                int id = scanner.nextInt();
                String name = scanner.next();
                String city = scanner.next();
                int salary = scanner.nextInt();
                Employee employee = new Employee(id,name,city,salary);
                try {
                    employeeRepository.addEmployee(employee);
                    System.out.println("Employee inserted successfully");
                } catch (SQLException e) {
                    System.out.println("Failed to add the Employee");
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}

// creating the statement
// executing the statement
// execute, excuteQuery, executeUpdate


//JPA --  Java persistent API
//ORM --- Object Relation mapping

//hibernate
//spring data jpa --- provides repository implementations that uses hibernate

//dao --  data access object -- handles the persistent logic

/*
*
* //        1. register the mysql driver class
//        2. create a database connection (database url, username, password)
//        3. create a query
//        4. execute the query
//        5. process the results returned by the query
//        6. close the connection
* */