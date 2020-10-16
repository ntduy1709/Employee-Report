package com.ifi.employeereportbe.service.imp;

import com.ifi.employeereportbe.dto.DepartmentDTO;
import com.ifi.employeereportbe.entity.Department;
import com.ifi.employeereportbe.repository.DepartmentRepository;
import com.ifi.employeereportbe.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return null;
    }

    @Override
    public DepartmentDTO getDepartmentDTO(String id) {
        return null;
    }

    @Override
    public DepartmentDTO updateDepartmentDTO(DepartmentDTO departmentDTO) {
        return null;
    }

    @Override
    public DepartmentDTO postDepartmentDTO(DepartmentDTO departmentDTO) {
        return null;
    }

    @Override
    public void deleteDepartmentDTO(DepartmentDTO departmentDTO) {

    }
}
