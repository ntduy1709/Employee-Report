package com.ifi.employeereportbe.service;

import com.ifi.employeereportbe.dto.EmployeeDTO;
import java.awt.*;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeDTO(String id);
    EmployeeDTO updateEmployeeDTO(EmployeeDTO employeeDTO);
    EmployeeDTO postEmployeeDTO(EmployeeDTO employeeDTO);
    void deleteEmployeeDTO(EmployeeDTO employeeDTO);
}
