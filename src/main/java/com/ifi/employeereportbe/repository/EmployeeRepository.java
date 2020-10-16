package com.ifi.employeereportbe.repository;

import com.ifi.employeereportbe.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
