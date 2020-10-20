package com.ifi.employeereportbe.service;


import com.ifi.employeereportbe.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> getAllEmployees();
    ProjectDTO getEmployeeDTO(String id);
    ProjectDTO updateEmployeeDTO(ProjectDTO projectDTO);
    ProjectDTO postEmployeeDTO(ProjectDTO projectDTO);
    void deleteEmployeeDTO(ProjectDTO projectDTO);
}
