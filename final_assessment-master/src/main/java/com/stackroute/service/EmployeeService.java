package com.stackroute.service;

import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    public List<Employee> getAll();
    public Employee getById(int id) throws EmployeeNotFoundException;
    public Employee addNew(Employee emp) throws EmployeeAlreadyExistException;
    public void deleteById(int id) throws EmployeeNotFoundException;
    public Employee updateById(Employee emp,int id) throws EmployeeNotFoundException;
    public List<Employee> searchByFirstName(String firstName) throws EmployeeNotFoundException;
}
