package com.hcl.employeedirectory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employeedirectory.beans.Employee;
import com.hcl.employeedirectory.dao.EmployeeDAO;
import com.hcl.employeedirectory.exception.IdException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeDAO dao;

	public List<Employee> employeesList() {
		return dao.findAll();
	}

	public Employee addEmployee(Employee employee) throws IdException {
		if (!dao.findById(employee.getId()).isPresent()) {
			return dao.saveAndFlush(employee);
		}

		else
			throw new IdException("Id already exist");
	}

	public Boolean deleteEmployee(int Id) throws IdException {
		if (dao.findById(Id).isPresent()) {
			dao.deleteById(Id);
			return true;
		} else
			throw new IdException("Id doesn't exist");

	}

	public Boolean updateEmployee(Employee employee, int Id) throws IdException {
		if (dao.findById(Id).isPresent()) {
			dao.saveAndFlush(employee);
			return true;
		} else
			throw new IdException("Id doesn't exist");

	}

	public Employee searchEmployeeById(int Id) throws IdException {
		if (dao.findById(Id).isPresent()) {
			return dao.findById(Id).get();
		} else
			throw new IdException("Id doesn't exist");
	}

}
