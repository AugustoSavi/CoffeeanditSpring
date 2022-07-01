package com.cofeeandit.limitessvc.LimiteDiario.controller;

import com.cofeeandit.limitessvc.LimiteDiario.model.LimiteDiario;
import com.cofeeandit.limitessvc.LimiteDiario.service.LimteDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/limite-diario")
public class LimiteDiarioController {

    @Autowired
    LimteDiarioService limteDiarioService;


    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LimiteDiario findById(@PathVariable("id") final Long id) {
        final Optional<LimiteDiario> limiteDiario = limteDiarioService.findById(id);
        if (limiteDiario.isPresent()) {
            return limiteDiario.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Recurso não encontrado");
    }
}
