package com.rajvardhan.ecommerce_springboot_backend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/")
    public String greet(){
        return "hello i am rajvardhan";
    }
}
