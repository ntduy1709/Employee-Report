package com.ifi.employeereportbe.service.imp;

import com.ifi.employeereportbe.dto.ProjectDTO;
import com.ifi.employeereportbe.entity.Project;
import com.ifi.employeereportbe.repository.ProjectRepository;
import com.ifi.employeereportbe.service.ProjectService;
import com.ifi.employeereportbe.service.SequenceGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @Override
    public List<ProjectDTO> getAllEmployees() {
        List<Project> projectList = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project project : projectList){
            ProjectDTO projectDTO = mapper.map(project, ProjectDTO.class);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @Override
    public ProjectDTO getEmployeeDTO(String id) {
        Project project = projectRepository.findById(id).orElse(null);
        return mapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateEmployeeDTO(ProjectDTO projectDTO) {
        String id = projectDTO.getId();
        Project project = projectRepository.findById(id).orElse(null);
        mapper.map(projectDTO, project);
        Project projectSaved = projectRepository.save(project);
        return mapper.map(projectSaved,ProjectDTO.class);
    }

    @Override
    public ProjectDTO postEmployeeDTO(ProjectDTO projectDTO) {
        Project project = mapper.map(projectDTO, Project.class);
     //   project.setId(sequenceGeneratorService.generateSequence(Project.SEQUENCE_NAME));
        Project projectSaved = projectRepository.save(project);
        return mapper.map(projectSaved,ProjectDTO.class);
    }

    @Override
    public void deleteEmployeeDTO(ProjectDTO projectDTO) {
        String id = projectDTO.getId();
        Project project = projectRepository.findById(id).orElse(null);
        projectRepository.delete(project);
    }
}
