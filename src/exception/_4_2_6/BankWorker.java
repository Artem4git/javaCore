package exception._4_2_6;

public interface BankWorker {
    boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException;
}
