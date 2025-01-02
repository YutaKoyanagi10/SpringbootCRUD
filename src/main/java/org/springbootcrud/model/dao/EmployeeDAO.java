package org.springbootcrud.model.dao;

import org.springbootcrud.model.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

}
