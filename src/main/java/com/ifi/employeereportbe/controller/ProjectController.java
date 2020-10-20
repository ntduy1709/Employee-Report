package com.ifi.employeereportbe.controller;

import com.ifi.employeereportbe.dto.ProjectDTO;
import com.ifi.employeereportbe.service.imp.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectServiceImp projectServiceImp;

    @GetMapping
    public List<ProjectDTO> getAllEmployees(){
        return projectServiceImp.getAllEmployees();
    }

    @GetMapping(value = "/{projectID}")
    public ProjectDTO getEmployeeDTO(@PathVariable String id){
        return projectServiceImp.getEmployeeDTO(id);
    }

    @PutMapping
    public ProjectDTO updateEmployeeDTO(@RequestBody ProjectDTO projectDTO){
        return projectServiceImp.updateEmployeeDTO(projectDTO);
    }

    @PostMapping
    public ProjectDTO postEmployeeDTO(@RequestBody ProjectDTO projectDTO){
        return projectServiceImp.postEmployeeDTO(projectDTO);
    }

    @DeleteMapping
    public void deleteEmployeeDTO(@RequestBody ProjectDTO projectDTO){
        projectServiceImp.deleteEmployeeDTO(projectDTO);
    }
}
