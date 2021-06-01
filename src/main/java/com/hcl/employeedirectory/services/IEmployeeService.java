package com.hcl.employeedirectory.services;

import java.util.List;

import com.hcl.employeedirectory.beans.Employee;
import com.hcl.employeedirectory.exception.IdException;

public interface IEmployeeService {

	public List<Employee> employeesList();

	public Employee addEmployee(Employee employee) throws IdException;

	public Boolean deleteEmployee(int Id) throws IdException;

	public Boolean updateEmployee(Employee employee, int Id) throws IdException;

	public Employee searchEmployeeById(int Id) throws IdException;
}
