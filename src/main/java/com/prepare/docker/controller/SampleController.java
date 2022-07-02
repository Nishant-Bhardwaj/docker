package com.prepare.docker.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class SampleController {

    @RequestMapping(value = "/{name}/get", method = RequestMethod.GET)
    public String sample(
            @PathVariable(name = "name")String empName,
            @RequestParam(name = "surname", required = false, defaultValue = "Sharma")String surname){

        return "Hello " + empName + " " + surname;
    }
}
