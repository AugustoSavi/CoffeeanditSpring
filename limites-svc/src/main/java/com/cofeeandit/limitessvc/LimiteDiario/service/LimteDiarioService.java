package com.cofeeandit.limitessvc.LimiteDiario.service;

import com.cofeeandit.limitessvc.LimiteDiario.model.LimiteDiario;
import com.cofeeandit.limitessvc.LimiteDiario.repositories.LimiteDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LimteDiarioService {

    @Autowired
    LimiteDiarioRepository limiteDiarioRepository;

    @Value("${limite.valor:0}")
    private BigDecimal valorLimiteDiario;


    public Optional<LimiteDiario> findById(final Long id){
        return limiteDiarioRepository.findById(id);
    }

    public Optional<LimiteDiario> findLimiteDiario(final Long agencia, final Long conta){
        Optional<LimiteDiario> limiteDiario = limiteDiarioRepository.findByAgenciaAndConta(agencia, conta);
        if (limiteDiario.isEmpty()){
            LimiteDiario newLimiteDiario = new LimiteDiario();
            newLimiteDiario.setAgencia(agencia);
            newLimiteDiario.setConta(conta);
            newLimiteDiario.setData(LocalDateTime.now());
            newLimiteDiario.setValor(valorLimiteDiario);

            return Optional.of(limiteDiarioRepository.save(newLimiteDiario));
        }
        return limiteDiario;
    }
}
