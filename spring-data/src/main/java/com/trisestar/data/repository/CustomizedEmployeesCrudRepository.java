package com.trisestar.data.repository;

import com.trisestar.data.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CustomizedEmployeesCrudRepository extends CrudRepository<Employee, Long> {
}
