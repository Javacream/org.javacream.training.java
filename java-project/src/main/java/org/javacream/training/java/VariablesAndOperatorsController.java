package org.javacream.training.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VariablesAndOperatorsController {

    @GetMapping("/operations")
    public String operations() {
        return "OK";
    }
}
