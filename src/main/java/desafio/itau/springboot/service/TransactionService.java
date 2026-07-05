package desafio.itau.springboot.service;
/**
 * Serviço responsável por armazenar e processar as transações.
 *
 * @author Matheus Fideles
 */

import org.springframework.stereotype.Service;
import desafio.itau.springboot.model.Transaction;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<>();

    // Adiciona uma nova transação
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Remove todas as transações armazenadas
    public void clearTransactions() {
        transactions.clear();
    }

    // Calcula as estatísticas das transações
    public DoubleSummaryStatistics getStatics() {
        OffsetDateTime now = OffsetDateTime.now();

        return transactions.stream()
                //.filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }
}
