package com.hcl.employeedirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hcl.employeedirectory.beans.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
