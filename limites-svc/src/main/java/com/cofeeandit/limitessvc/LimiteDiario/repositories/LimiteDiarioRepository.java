package com.cofeeandit.limitessvc.LimiteDiario.repositories;

import com.cofeeandit.limitessvc.LimiteDiario.model.LimiteDiario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface LimiteDiarioRepository extends CrudRepository<LimiteDiario,Long> {

    Optional<LimiteDiario> findByAgenciaAndConta(Long agencia, Long conta);

    Optional<LimiteDiario> findByAgenciaAndContaAndData(final Long agencia, final Long conta, final LocalDateTime data);
}
