package org.revo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class AzureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureApplication.class, args);
    }
}

@RestController
class web {
    @GetMapping
    public String index(HttpServletRequest request) {
        return "hello   azure    {path }" + request.getServletContext().getRealPath("");
    }
}