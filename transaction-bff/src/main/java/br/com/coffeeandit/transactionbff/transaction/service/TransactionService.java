package br.com.coffeeandit.transactionbff.transaction.service;

import br.com.coffeeandit.transactionbff.redis.repositories.TransactionRedisRepository;
import br.com.coffeeandit.transactionbff.transaction.dto.RequestTransactionDto;
import br.com.coffeeandit.transactionbff.transaction.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRedisRepository transactionRedisRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Transactional
    public Optional<TransactionDto> save(final RequestTransactionDto requestTransactionDto){
        requestTransactionDto.setDateTime(LocalDateTime.now());
       return Optional.of(transactionRedisRepository.save(requestTransactionDto));
    }

    @Transactional
    public Optional<TransactionDto> findById(final String id){
        return transactionRedisRepository.findById(id);
    }
}
