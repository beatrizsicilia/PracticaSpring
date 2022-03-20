package com.example.AplicacionFormularios;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ControladorRegistro {

    @PostMapping(path = "/inicioSesion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkPersonInfo(@Valid @RequestBody Registro registro,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return new ResponseEntity<>("{\"result\" : \"KO: BAD REQUEST\"}", HttpStatus.BAD_REQUEST);
        }

        if ((registro.usuario().equals("beasicilia@yahoo.es")) &&
                (registro.password().equals("contra"))) {

            return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);

        }
        return new ResponseEntity<>("{\"result\" : \"KO: UNAUTHORIZED\"}", HttpStatus.UNAUTHORIZED);

    }
}