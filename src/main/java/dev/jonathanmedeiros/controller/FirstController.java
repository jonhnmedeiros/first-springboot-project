package dev.jonathanmedeiros.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstController")
public class FirstController {

    @GetMapping("/firstMethod/{id}")
    public String firstMethod(@PathVariable String id) {
        return "Params id " + id;
    }

    @GetMapping("/queryParamsMethod")
    public String queryParamsMethod(@RequestParam String id) {
        return "QueryParams id " + id;
    }

    @GetMapping("/queryParamsMethod2")
    public String queryParamsMethod2(@RequestParam Map<String, String> allParams) {
        return "QueryParams2 is: " + allParams.entrySet();
    }

    @PostMapping("/bodyParamsMethod")
    public String bodyParamsMethod(@RequestBody User user) {
        return "bodyParamsMethod " + user.username();
    }

    @PostMapping("/headersMethod")
    public String headersMethod(@RequestHeader("name") String name) {
        return "headersMethod " + name;
    }

    @PostMapping("/headersListMethod")
    public String headersListMethod(@RequestHeader  Map<String, String> headers){
        return "headersListMethod " + headers.entrySet();
    }

    @GetMapping("/responseEntityMethod/{id}")
    public ResponseEntity<Object> responseEntityMethod(@PathVariable Long id) {
        var user = new User("Jonathan Medeiros");

        if(id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.badRequest().body("Number < 5");
        
    }

    record User(String username){}

    
}
