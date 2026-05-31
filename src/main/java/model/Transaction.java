package model;

/**
 * Representa uma transação financeira.
 * Armazena o valor e a data/hora da transação.
 *
 * @author Matheus Fideles
 */

import java.time.OffsetDateTime;

public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;

    public Transaction(final double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}