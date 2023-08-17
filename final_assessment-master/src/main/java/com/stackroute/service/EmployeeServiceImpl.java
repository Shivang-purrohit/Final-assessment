package com.stackroute.service;

import com.stackroute.dao.EmployeeRepository;
import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    
    @Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> allEmployee = employeeRepository.findAll();
		return allEmployee;
	}

	@Override
	public Employee getById(int id) throws EmployeeNotFoundException {
		Optional<Employee> findEmployeeById = employeeRepository.findById(id);
		if(findEmployeeById.isEmpty()) {
			throw new EmployeeNotFoundException("No employee found by this id");
		}
		return findEmployeeById.get();
	}

	@Override
	public Employee addNew(Employee emp) throws EmployeeAlreadyExistException {
		int id = emp.getId();
		Optional<Employee> findEmployeeById= employeeRepository.findById(id);
		if(findEmployeeById.isEmpty()) {
			Employee employee = employeeRepository.save(emp);
			return employee;
		}
		else {
			throw new EmployeeAlreadyExistException("Employee with give id already exists");
		}
	}

	@Override
	public void deleteById(int id) throws EmployeeNotFoundException {
		Optional<Employee> findEmployeeById = employeeRepository.findById(id);
		if(findEmployeeById.isEmpty()) {
			throw new EmployeeNotFoundException("No employee found by this id");
		}
		employeeRepository.deleteById(id);	
	}

	@Override
	public Employee updateById(Employee emp, int id) throws EmployeeNotFoundException {
		Optional<Employee> findEmployeeById = employeeRepository.findById(id);
		if(findEmployeeById.isEmpty()) {
			throw new EmployeeNotFoundException("No employee found by this id");
		}
		Employee newEmployee = findEmployeeById.get();
		if(emp.getFirstName()!=null) {
			newEmployee.setFirstName(emp.getFirstName());
		}
		if(emp.getDepartment()!=null) {
			newEmployee.setDepartment(emp.getDepartment());
		}
		if(emp.getWorkLocation()!=null) {
			newEmployee.setWorkLocation(emp.getWorkLocation());
		}
		employeeRepository.save(newEmployee);
		return newEmployee;
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) throws EmployeeNotFoundException {
		List<Employee> findByFirstName = employeeRepository.findByFirstName(firstName);
		if(findByFirstName.isEmpty()) {
			throw new EmployeeNotFoundException("No employee where found by the given names");
		}
		return findByFirstName;
	}

    


   }
