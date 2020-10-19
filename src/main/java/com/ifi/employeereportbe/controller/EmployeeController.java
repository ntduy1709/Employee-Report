package com.ifi.employeereportbe.controller;

import com.ifi.employeereportbe.dto.EmployeeDTO;
import com.ifi.employeereportbe.service.imp.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;


    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeServiceImp.getAllEmployees();
    }

    @GetMapping(value = "/{employeeID}")
    public EmployeeDTO getEmployeesDTO(@PathVariable(value = "employeeID") String id){
        return employeeServiceImp.getEmployeeDTO(id);
    }

    @PostMapping
    public EmployeeDTO postEmployeeDTO(@RequestBody EmployeeDTO employeeDTO){
        return employeeServiceImp.postEmployeeDTO(employeeDTO);
    }

    @PutMapping
    public EmployeeDTO updateEmployeeDTO(@RequestBody EmployeeDTO employeeDTO){
        return employeeServiceImp.updateEmployeeDTO(employeeDTO);
    }

    @DeleteMapping
    public void deleteEmployeeDTO(@RequestBody EmployeeDTO employeeDTO){
        employeeServiceImp.deleteEmployeeDTO(employeeDTO);
    }
}
