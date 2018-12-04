package com.example.manytomany.controllers;

import com.example.manytomany.models.Employee;
import com.example.manytomany.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }



}
