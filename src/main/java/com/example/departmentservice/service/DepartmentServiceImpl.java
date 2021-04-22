package com.example.departmentservice.service;

import com.example.departmentservice.dao.DepartmentDao;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override

    public Department createDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override

    public List<Department> displayAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(String id) {
        return departmentDao.findById(id);
    }
}