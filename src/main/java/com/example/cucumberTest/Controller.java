package com.example.cucumberTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private IService service;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(required = false) String nome) {
        return service.hello(nome);
    }

    @PostMapping("/checkNumber")
    public ResponseEntity<String> checkNumber(@RequestBody NumberRequest request) {
        return service.checkNumber(request);
    }
}
