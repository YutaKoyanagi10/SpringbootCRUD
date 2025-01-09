package org.springbootcrud.services.impl;

import org.springbootcrud.repository.EmployeeRepository;
import org.springbootcrud.model.entity.Employee;
import org.springbootcrud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Transactional(readOnly = true)
    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else {
            throw new RuntimeException("Employee not found");
        }
    }
    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Transactional
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Employee not found")
        );
        existingEmployee.setName(employee.getName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
    @Transactional
    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        employeeRepository.deleteById(id);
    }
}
