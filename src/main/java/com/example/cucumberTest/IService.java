package com.example.cucumberTest;

import org.springframework.http.ResponseEntity;

public interface IService {
    public ResponseEntity<String> hello(String nome);
    public ResponseEntity<String> checkNumber(NumberRequest request);
}
