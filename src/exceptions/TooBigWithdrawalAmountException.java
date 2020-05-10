package exceptions;

public class TooBigWithdrawalAmountException extends Exception {
    public TooBigWithdrawalAmountException(double withdrawalAmount, double accountBalance) {
        super("Withdrawal amount bigger than account balance. Account balance: " + accountBalance
                + "zł. Withdrawal amount is " + (withdrawalAmount - accountBalance) + "zł bigger.");
    }

}
