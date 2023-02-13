package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TokenResource {

    private InterfaceRepository tokenRepository;

    public TokenResource(InterfaceRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
    
//    @GetMapping("/")
//    public ResponseEntity<Object> home() {
//        return new ResponseEntity<Object>(tokenRepository.findById("3FjaMee"), HttpStatus.OK);
//    }

    @GetMapping("/add")
    public Token add() {
//    	tokenRepository.save(new Token("3FjaMee","http://localhost:8080/"));
    	tokenRepository.save(new Token("3FjaMee22","http://localhost:8082/"));
        return tokenRepository.findById("3FjaMee22");
    }
    @GetMapping("/")
    public Object home() {
    	System.out.println("Home Page ..... ");
    	HashMap<String,String> hm = new HashMap();
    	hm.put("result", "success");
        return hm;
    }
    @GetMapping("/gettoken/{id}")
    public ResponseEntity<String> getToken(@PathVariable String id) {
    	System.out.println("Getting value from Redis ..... ");
    	System.out.println("Value of path parameter is :: "+id);
    	Token value  = tokenRepository.findById(id);
    	System.out.println("Value from Redis short uri :: "+value.getShort_url()+" long uri :: "+value.getLong_url());
    	HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, value.getLong_url());
        return new ResponseEntity<String>(headers,HttpStatus.MOVED_PERMANENTLY);
    }
}