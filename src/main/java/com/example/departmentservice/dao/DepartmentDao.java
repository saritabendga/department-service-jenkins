package com.example.departmentservice.dao;

import com.example.departmentservice.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends MongoRepository<Department,String> {
}