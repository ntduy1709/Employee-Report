package com.ifi.employeereportbe.service.imp;

import com.ifi.employeereportbe.dto.EmployeeDTO;
import com.ifi.employeereportbe.entity.Employee;
import com.ifi.employeereportbe.repository.EmployeeRepository;
import com.ifi.employeereportbe.service.EmployeeService;
import com.ifi.employeereportbe.service.SequenceGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee: employeeList){
            EmployeeDTO employeeDTO = modelMapper.map(employee,EmployeeDTO.class);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployeeDTO(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeDTO employeeDTO = modelMapper.map(employee,EmployeeDTO.class);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployeeDTO(EmployeeDTO employeeDTO) {
        String id = employeeDTO.getId();
        Employee employee = employeeRepository.findById(id).orElse(null);
        modelMapper.map(employeeDTO, employee);
        Employee employeeSaved = employeeRepository.save(employee);
        return modelMapper.map(employeeSaved, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO postEmployeeDTO(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        Employee employeeSaved = employeeRepository.save(employee);
        return modelMapper.map(employeeSaved,EmployeeDTO.class);
    }

    @Override
    public void deleteEmployeeDTO(EmployeeDTO employeeDTO) {
        String id = employeeDTO.getId();
        Employee employee = employeeRepository.findById(id).orElse(null);
        employeeRepository.delete(employee);
    }
}
