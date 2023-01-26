package com.stackroute.repository;

import com.stackroute.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    private String url;
    private String userName;
    private String password;
    private Connection connection;

    public EmployeeRepositoryImpl(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    protected void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to register the driver class");
        }
        try {
            this.connection = DriverManager.getConnection(this.url,this.userName,this.password);
        } catch (SQLException e) {
            System.out.println("Failed to create a database connection");
        }
    }

    protected  void disconnect(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to close the connection");
        }
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        connect();
        String query = "select * from employee";
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Employee> employees = new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("emp_id");
            String name = resultSet.getString("emp_name");
            String city = resultSet.getString("city");
            int salary = resultSet.getInt("salary");

            Employee employee = new Employee(id,name,city,salary);
            employees.add(employee);
        }

        resultSet.close();
        statement.close();
        disconnect();
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException {
        connect();
        String query = "insert into employee values(?,?,?,?)";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setInt(1,employee.getEmployeeId());
        statement.setString(2,employee.getEmployeeName());
        statement.setString(3,employee.getCity());
        statement.setInt(4,employee.getSalary());
        boolean status = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return status;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) throws SQLException {
        return false;
    }
}
