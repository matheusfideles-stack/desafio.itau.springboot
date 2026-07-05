package desafio.itau.springboot.controller;

/**
 * @author Matheus Fideles
 */

import Service.TransactionService;
import dto.TransactionRequest;
import jakarta.validation.Valid;
import model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Cadastra uma nova transação
    @PostMapping
    public ResponseEntity<Void> createTransaction(
            @Valid @RequestBody TransactionRequest request) {

        // Valida data futura e valor inválido
        if (request.getDataHora().isAfter(OffsetDateTime.now())
                || request.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionService.addTransaction(
                new Transaction(
                        request.getValor(),
                        request.getDataHora()
                )
        );

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Remove todas as transações armazenadas
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
