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
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImp departmentServiceImp;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments(){
        return departmentServiceImp.getAllDepartments();
    }

    @GetMapping(value = "/{departmentID}")
    public DepartmentDTO getDepartmentDTO(@PathVariable String id){
        return departmentServiceImp.getDepartmentDTO(id);
    }

    @PostMapping
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentServiceImp.createDepartmentDTO(departmentDTO);
    }

    @PutMapping
    public DepartmentDTO updateDepartmentDTO(@RequestBody DepartmentDTO departmentDTO){
        return departmentServiceImp.updateDepartmentDTO(departmentDTO);
    }

    @DeleteMapping
    public void deleteDepartmentDTO(DepartmentDTO departmentDTO){
        departmentServiceImp.deleteDepartmentDTO(departmentDTO);
    }

}
