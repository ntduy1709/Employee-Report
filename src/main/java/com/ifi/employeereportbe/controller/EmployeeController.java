package com.ifi.employeereportbe.controller;

import com.ifi.employeereportbe.dto.EmployeeDTO;
import com.ifi.employeereportbe.service.imp.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;


    @GetMapping(value = "/all")
    public List<EmployeeDTO> getEmployees(){
        return employeeServiceImp.getAllEmployees();
    }


}
