package com.example.cucumberTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringDemoApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {
    @Autowired
    private RestTemplate restTemplate;

    private static String checkNumberResponse;
    private static String greeting;

    void executeGet(String url, String nome) throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, Map.of("nome", nome));
        if(response.getBody() != null)
        {
            greeting = (String) response.getBody();
        }
        else {
            throw new Exception("C'è stato un errore durante la chiamata al servizio /hello");
        }
    }

    void executeGet(String url) throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getBody() != null)
        {
            greeting = response.getBody();
        }
        else {
            throw new Exception("C'è stato un errore durante la chiamata al servizio /hello");
        }
    }

    boolean isExpectedHello(String expected) throws Exception {
        if(expected == null || expected.equalsIgnoreCase(""))
        {
            throw new Exception("Expected di /hello vuoto!");
        }
        if(greeting == null)
        {
            throw new Exception("Response di /hello vuota!");
        }

        return expected.equalsIgnoreCase(greeting);
    }

    void executePost(String url, String request) throws Exception {
        NumberRequest numberRequest = (new ObjectMapper()).readValue(request, NumberRequest.class);

        ResponseEntity<String> response = restTemplate.postForEntity(url, numberRequest, String.class);
        if(response.getBody() != null)
        {
            checkNumberResponse = response.getBody();
        }
        else {
            throw new Exception("C'è stato un errore durante la chiamata al servizio /checkNumber");
        }
    }

    boolean isExpectedCheckNumber(String expected) throws Exception {
        if(expected == null || expected.equalsIgnoreCase(""))
        {
            throw new Exception("Expected di /checkNumber vuoto!");
        }
        if(checkNumberResponse == null)
        {
            throw new Exception("Response di /checkNumber vuota!");
        }

        return expected.equalsIgnoreCase(checkNumberResponse);
    }

}
