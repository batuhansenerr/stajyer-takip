package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.dto.DepartmentDto;
import com.batuhansener.stajyerTakip.dto.request.CreateDepartmentRequest;
import com.batuhansener.stajyerTakip.dto.request.UpdateDepartmentRequest;
import com.batuhansener.stajyerTakip.exception.DepartmentNotFoundException;
import com.batuhansener.stajyerTakip.model.Department;
import com.batuhansener.stajyerTakip.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> departments = (List<DepartmentDto>) departmentRepository.findAll().stream().map(
                department->DepartmentDto.builder().name(department.getName()).id(department.getId())
                        .mentors(department.getMentors()).build());
        return departments;
    }

    public DepartmentDto createDepartment(CreateDepartmentRequest request) {
        Department department = departmentRepository.save(Department.builder().name(request.getName()).build());
        return DepartmentDto.builder().id(department.getId()).name(department.getName()).build();
    }

    private Department findDepartmentById(String id){
        return departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("Böyle bir departman yok"));
    }

    public void deleteDepartment(String id) {
        Department department = findDepartmentById(id);
        departmentRepository.delete(department);
    }

//    public DepartmentDto updateDepartment(UpdateDepartmentRequest request) {
//
//    }
}
