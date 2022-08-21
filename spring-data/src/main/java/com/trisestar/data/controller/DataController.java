package com.trisestar.data.controller;

import com.trisestar.data.model.Employee;
import com.trisestar.data.repository.CustomizedEmployeesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DataController {

    private final CustomizedEmployeesCrudRepository employeesCrudRepository;



    @Autowired
    public DataController(CustomizedEmployeesCrudRepository employeesCrudRepository) {
        this.employeesCrudRepository = employeesCrudRepository;
    }

    @PostMapping
    public Object createEmployee(@RequestBody Employee employee){
        return employeesCrudRepository.save(employee);
    }

}
