package controller;

/**
 * @author Matheus Fideles
 */

import Service.TransactionService;
import dto.StatisticsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Retorna as estatísticas das transações dos últimos 60 segundos
    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {

        DoubleSummaryStatistics stats = transactionService.getStatics();

        return ResponseEntity.ok(
                new StatisticsResponse(stats)
        );
    }
}