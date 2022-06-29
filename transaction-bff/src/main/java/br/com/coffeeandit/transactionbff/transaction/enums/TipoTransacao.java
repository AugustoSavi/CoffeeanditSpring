package br.com.coffeeandit.transactionbff.transaction.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum TipoTransacao {
    PAGAMENTO_TRIBUTOS,
    PAGAMENTO_TITULOS,
    TED,
    DOC;
}
