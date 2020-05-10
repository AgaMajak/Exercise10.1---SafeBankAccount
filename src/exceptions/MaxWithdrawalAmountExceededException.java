package exceptions;

public class MaxWithdrawalAmountExceededException extends Exception {
    public MaxWithdrawalAmountExceededException(double withdrawalAmount, double maxAmount){
        super("Withdrawal amount bigger than max withdrawal amount. Max withdrawal amount: " + maxAmount
                + "zł. Withdrawal amount is " + (withdrawalAmount - maxAmount) + "zł bigger.");
    }
}
