package org.springbootcrud.services;

import org.springbootcrud.model.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Iterable<Employee> getAllEmployees();
    void deleteEmployee(Integer id);
    Employee getEmployee(Integer id);
}
