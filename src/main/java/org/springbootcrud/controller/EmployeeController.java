package org.springbootcrud.controller;

import org.springbootcrud.model.entity.Employee;
import org.springbootcrud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> create (@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") long id,
                                                   @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted Successfully.", HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> get(@PathVariable("id") long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

}
