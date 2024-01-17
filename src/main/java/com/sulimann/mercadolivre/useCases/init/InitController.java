package com.sulimann.mercadolivre.useCases.init;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.mercadolivre.utils.URI;

@RestController
public class InitController {

    @GetMapping(value = URI.INIT)
    public ResponseEntity<Object> init(){
        return ResponseEntity.status(HttpStatus.OK).body("Get realizado com sucesso!");
    }
    
}
