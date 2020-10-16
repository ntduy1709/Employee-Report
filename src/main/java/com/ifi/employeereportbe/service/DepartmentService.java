package com.ifi.employeereportbe.service;


import com.ifi.employeereportbe.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO getDepartmentDTO(String id);
    DepartmentDTO updateDepartmentDTO(DepartmentDTO departmentDTO);
    DepartmentDTO postDepartmentDTO(DepartmentDTO departmentDTO);
    void deleteDepartmentDTO(DepartmentDTO departmentDTO);

}
