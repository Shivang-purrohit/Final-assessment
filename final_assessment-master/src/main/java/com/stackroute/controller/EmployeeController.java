package com.stackroute.controller;

import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import com.stackroute.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
    public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
    	List<Employee> allEmployees = employeeService.getAll();
    	return new ResponseEntity<>(allEmployees,HttpStatus.OK);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee emp) throws EmployeeAlreadyExistException {
    	Employee newEmp = employeeService.addNew(emp);
    	return new ResponseEntity<>(newEmp,HttpStatus.OK);

    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
    	Employee employeeById = employeeService.getById(id);
    	return new ResponseEntity<>(employeeById,HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
    	employeeService.deleteById(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee emp,@PathVariable int id) throws EmployeeNotFoundException {
    	Employee updatedemployee = employeeService.updateById(emp, id);
    	return new ResponseEntity<>(updatedemployee,HttpStatus.OK);
    }

    @GetMapping(value = "/employees/name/{firstName}")
    public ResponseEntity<List<Employee>> SearchEmployeeByFirstName(@PathVariable String firstName) throws EmployeeNotFoundException {
    	List<Employee> searchByFirstName = employeeService.searchByFirstName(firstName);
    	return new ResponseEntity<>(searchByFirstName,HttpStatus.OK);
    }

}
