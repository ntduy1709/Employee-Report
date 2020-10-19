package com.ifi.employeereportbe.controller;


import com.ifi.employeereportbe.dto.DepartmentDTO;
import com.ifi.employeereportbe.entity.Department;
import com.ifi.employeereportbe.service.SequenceGeneratorService;
import com.ifi.employeereportbe.service.imp.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImp departmentServiceImp;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping
    public List<DepartmentDTO> getDepartments(){
        return departmentServiceImp.getAllDepartments();
    }

    @PostMapping
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO department) {
        department.setId(sequenceGeneratorService.generateSequence(Department.SEQUENCE_NAME));
        return departmentServiceImp.createDepartmentDTO(department);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") String departmentId,
                                                           @RequestBody Department department){
        DepartmentDTO departmentDTO;
        return null;
    }

}
