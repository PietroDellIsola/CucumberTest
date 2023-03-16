package com.example.cucumberTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService{

    @Override
    public ResponseEntity<String> hello(String nome) {
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Custom-Header", "foo");

        return (nome == null || nome.equals("")) ?
                new ResponseEntity<>("Ciao mondo!", headers, HttpStatus.OK) :
                new ResponseEntity<>("Ciao ".concat(nome).concat("!"), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> checkNumber(NumberRequest request) {
        HttpHeaders headers = new HttpHeaders();
        return (request == null || request.getNumber() == null) ?
                new ResponseEntity<>("Nessun numero specificato!", headers, HttpStatus.OK) :
                (request.getNumber() % 2 == 0) ?
                        new ResponseEntity<>("Il numero è pari!", headers, HttpStatus.OK) :
                        new ResponseEntity<>("Il numero è dispari!", headers, HttpStatus.OK);
    }
}
