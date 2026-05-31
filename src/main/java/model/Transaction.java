package model;

import java.time.OffsetDateTime;

public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;

    public Transaction(final double valor, final OffsetDateTime dataHora) {
    }

    public double getValor() {
        return valor;
    }

}