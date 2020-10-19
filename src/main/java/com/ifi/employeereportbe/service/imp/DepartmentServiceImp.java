package com.ifi.employeereportbe.service.imp;

import com.ifi.employeereportbe.dto.DepartmentDTO;
import com.ifi.employeereportbe.dto.EmployeeDTO;
import com.ifi.employeereportbe.entity.Department;
import com.ifi.employeereportbe.entity.Employee;
import com.ifi.employeereportbe.repository.DepartmentRepository;
import com.ifi.employeereportbe.service.DepartmentService;
import com.ifi.employeereportbe.service.SequenceGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department: departments){
            DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }

    @Override
    public DepartmentDTO getDepartmentDTO(String id) {
        Department department = departmentRepository.findById(id).orElse(null);
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return departmentDTO;
    }

    @Override
    public DepartmentDTO updateDepartmentDTO(DepartmentDTO departmentDTO) {
        String id = departmentDTO.getId();
        Department department = departmentRepository.findById(id).orElse(null);
        modelMapper.map(departmentDTO, department);
        Department updatedDepartment = departmentRepository.save(department);
        return modelMapper.map(updatedDepartment, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO createDepartmentDTO(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        department.setId(sequenceGeneratorService.generateSequence(Department.SEQUENCE_NAME));
        Department departmentSaved = departmentRepository.save(department);
        return modelMapper.map(departmentSaved, DepartmentDTO.class);
    }

    @Override
    public void deleteDepartmentDTO(DepartmentDTO departmentDTO) {
        String id = departmentDTO.getId();
        Department department = departmentRepository.findById(id).orElse(null);
        departmentRepository.delete(department);
    }
}
