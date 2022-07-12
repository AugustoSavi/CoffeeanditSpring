package br.com.coffeeandit.transactionsvc.transaction.repository;

import br.com.coffeeandit.transactionsvc.transaction.dto.TransactionDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionDto, UUID> {
}
