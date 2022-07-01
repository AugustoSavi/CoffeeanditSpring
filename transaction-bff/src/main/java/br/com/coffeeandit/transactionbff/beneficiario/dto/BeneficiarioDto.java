package br.com.coffeeandit.transactionbff.beneficiario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class BeneficiarioDto implements Serializable {

    @Schema(description = "CPF do Beneficiário")
    @NotNull(message = "Informar o cpf")
    private Long cpf;

    @NotNull(message = "Informar o código do banco de destino.")
    @Schema(description = "Código do banco de destino")
    private Long codigoBanco;

    @NotNull(message = "Informar a agência de destino.")
    @Schema(description = "Agência de destino")
    private String agencia;

    @NotNull(message = "Informar a conta de destino.")
    @Schema(description = "Conta de destino")
    private String conta;

    @NotNull(message = "Informar o nome do favorecido.")
    @Schema(description = "Nome do favorecido")
    private String nomeFavorecido;
}
