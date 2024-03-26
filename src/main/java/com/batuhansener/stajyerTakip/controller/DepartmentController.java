package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.DepartmentDto;
import com.batuhansener.stajyerTakip.dto.request.CreateDepartmentRequest;
import com.batuhansener.stajyerTakip.dto.request.UpdateDepartmentRequest;
import com.batuhansener.stajyerTakip.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping("/addNewDepartment")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody CreateDepartmentRequest request){
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

    @DeleteMapping("/{department_id}")
    public void deleteDepartment(@RequestParam String request){
        departmentService.deleteDepartment(request);
    }

//    @PutMapping("/update")
//    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody UpdateDepartmentRequest request){
//        return ResponseEntity.ok(departmentService.updateDepartment(request));
//    }
}
