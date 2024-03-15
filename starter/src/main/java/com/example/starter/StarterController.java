package com.example.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarterController {
    @GetMapping(path="/hello")
    public String helloworld(){
        return "Hello AP";
    }
}
