package com.stackroute.dao;

import com.stackroute.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	List<Employee> findByFirstName(String firstName);
}
