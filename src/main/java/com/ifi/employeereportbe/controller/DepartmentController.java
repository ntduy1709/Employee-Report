package com.ifi.employeereportbe.controller;


import com.ifi.employeereportbe.entity.Department;
import com.ifi.employeereportbe.service.imp.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImp departmentServiceImp;

}
