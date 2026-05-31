package controller;

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

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest resquest) {
            if (resquest.getDataHora().isAfter(OffsetDateTime.now()) || resquest.getValor() <=0) {
                    return ResponseEntity.unprocessableEntity().build();
            }
            transactionService.addTransaction(new Transaction(resquest.getValor(), resquest.getDataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
