package br.com.coffeeandit.transactionbff.redis.repositories;

import br.com.coffeeandit.transactionbff.transaction.dto.TransactionDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRedisRepository extends CrudRepository<TransactionDto, String> {
}
