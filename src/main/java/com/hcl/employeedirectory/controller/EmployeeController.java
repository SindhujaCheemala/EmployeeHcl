package com.hcl.employeedirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employeedirectory.beans.Employee;
import com.hcl.employeedirectory.exception.IdException;
import com.hcl.employeedirectory.services.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl emp;

	@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> employeesList() {
		return new ResponseEntity<List<Employee>>(emp.employeesList(), HttpStatus.CREATED);
	}

	@PostMapping("/api/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) throws IdException {
		return new ResponseEntity<Employee>(emp.addEmployee(e), HttpStatus.CREATED);

	}

	@GetMapping("/api/employees/{Id}")
	public ResponseEntity<Employee> searchEmployeeById(@PathVariable int Id) throws IdException {
		return new ResponseEntity<Employee>(emp.searchEmployeeById(Id), HttpStatus.CREATED);
	}

	@DeleteMapping("/api/employees/{Id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int Id) throws IdException {
		return new ResponseEntity<Boolean>(emp.deleteEmployee(Id), HttpStatus.CREATED);

	}

	@PutMapping("/api/employees/{Id}")
	public ResponseEntity<Boolean> updateEmployee(@PathVariable int Id, @RequestBody Employee e) throws IdException {
		return new ResponseEntity<Boolean>(emp.updateEmployee(e, Id), HttpStatus.CREATED);
	}

}
