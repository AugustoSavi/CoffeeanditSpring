package com.cofeeandit.limitessvc.LimiteDiario.service;

import com.cofeeandit.limitessvc.LimiteDiario.model.LimiteDiario;
import com.cofeeandit.limitessvc.LimiteDiario.repositories.LimiteDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LimteDiarioService {

    @Autowired
    LimiteDiarioRepository limiteDiarioRepository;


    public Optional<LimiteDiario> findById(final Long id){
        return limiteDiarioRepository.findById(id);
    }
}
