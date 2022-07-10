package com.prepare.docker.controller;

import com.prepare.docker.EmpRepo;
import com.prepare.docker.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class SampleController {

    @Autowired
    EmpRepo empRepo;

    @RequestMapping(value = "/{name}/get", method = RequestMethod.GET)
    public String sample(
            @PathVariable(name = "name")String empName,
            @RequestParam(name = "surname", required = false, defaultValue = "Sharma")String surname){

        return "Hello " + empName + " " + surname;
    }

    @GetMapping(value = "/{id}/insert")
    public ResponseEntity<Object> insertEmp(@PathVariable("id") Integer id){
        return new ResponseEntity<>(empRepo.save(new Employee(id,"Nishant")), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllEmp(){
        return new ResponseEntity<>(empRepo.findAll(), HttpStatus.CREATED);
    }
}
