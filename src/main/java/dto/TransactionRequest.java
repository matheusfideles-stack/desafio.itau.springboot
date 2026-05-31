package dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

/**
 * DTO utilizado para receber os dados de uma transação.
 *
 * @author Matheus Fideles
 */

public class TransactionRequest {

    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}