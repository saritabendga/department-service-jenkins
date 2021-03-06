package com.example.departmentservice.rest;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<Department>(departmentService.createDepartment(department),HttpStatus.CREATED);
    }
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> displayAll()
    {
        return new ResponseEntity<List<Department>>(departmentService.displayAllDepartment(),HttpStatus.OK);
    }



    @GetMapping("/departments/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartmentById(id));
    }

    @DeleteMapping("/departments/delete/{id}")
    public String deleteDepartmentbyId(@PathVariable("id") String id)
    {
        departmentService.deletebyId(id);
        return "Employee record with" +id+ "deleted";
    }

}