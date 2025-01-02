package org.springbootcrud.services.impl;

import org.springbootcrud.model.dao.EmployeeDAO;
import org.springbootcrud.model.entity.Employee;
import org.springbootcrud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeDAO.findAll();
    }

    @Transactional
    @Override
    public void deleteEmployee(Integer id) {
        employeeDAO.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getEmployee(Integer id) {
        return employeeDAO.findById(id).orElse(null);
    }
}
