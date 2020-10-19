package com.ifi.employeereportbe.repository;

import com.ifi.employeereportbe.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
