package br.com.coffeeandit.transactionbff.transaction.controller;

import br.com.coffeeandit.transactionbff.exception.NotFoundException;
import br.com.coffeeandit.transactionbff.transaction.dto.RequestTransactionDto;
import br.com.coffeeandit.transactionbff.transaction.dto.TransactionDto;
import br.com.coffeeandit.transactionbff.transaction.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(description = "API para busca as transações persistidas por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno Ok com a transação."),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @ApiResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
    })
    @Parameters(value = {@Parameter(name = "id", in = ParameterIn.PATH)})
    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionDto> getTransaction(@PathVariable("id") final String uuid) {
        final Optional<TransactionDto> transactionDto = transactionService.findById(uuid);
        if (transactionDto.isPresent()) {
            return Mono.just(transactionDto.get());
        }
        throw new NotFoundException("Não encontrado");
    }

    @Operation(description = "API para criar uma transação financeira")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorno Ok com a transação criada."),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @ApiResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
    })
    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionDto> postTransaction(@RequestBody final RequestTransactionDto requestTransactionDto) {
        final Optional<TransactionDto> transactionDto = transactionService.save(requestTransactionDto);
        if (transactionDto.isPresent()) {
            return Mono.just(transactionDto.get());
        }
        throw new NotFoundException("Não encontrado");
    }

    @Operation(description = "API para remover a transaçãp persistida por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Retorno Ok para remoção"),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @ApiResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
    })
    @Parameters(value = {@Parameter(name = "id", in = ParameterIn.PATH)})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionDto> deleteTransaction(@PathVariable("id") final String id) {
        return Mono.empty();
    }

    @Operation(description = "API para confirmar a transação persistida por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno Ok para remoção"),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @ApiResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
    })
    @Parameters(value = {@Parameter(name = "id", in = ParameterIn.PATH)})
    @PatchMapping(value = "/{id}/confirm")
    public Mono<TransactionDto> patchTransaction(@PathVariable("id") final String id) {
        return Mono.empty();
    }
}
