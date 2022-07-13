package br.com.coffeeandit.transactionbff.limite.controller;

import br.com.coffeeandit.transactionbff.limite.feign.LimiteClient;
import br.com.coffeeandit.transactionbff.limite.model.LimiteDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limites")
public class LimiteController {

    @Autowired
    private LimiteClient limiteClient;

    @GetMapping(value = "/{agencia}/{conta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LimiteDiario findLimiteDiario(@PathVariable("agencia") final Long agencia, @PathVariable("conta") final Long conta) {
        return limiteClient.findLimiteDiario(agencia, conta);
    }
}
