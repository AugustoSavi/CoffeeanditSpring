package br.com.coffeeandit.transactionsvc.transaction.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum SituacaoTransacaoEnum {
    ANALISADA,
    NAO_ANALISADA,
    EM_ANALISE_HUMANA,
    EM_SUSPEITA_FRAUDE,
    RISCO_CONFIRMADO;
}
