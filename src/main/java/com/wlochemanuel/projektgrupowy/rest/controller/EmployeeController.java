package com.wlochemanuel.projektgrupowy.rest.controller;

import com.wlochemanuel.projektgrupowy.rest.model.Employee;
import com.wlochemanuel.projektgrupowy.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> get(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(this.employeeService.findById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.add(employee));
    }
}
