import data.Person;
import exceptions.MaxWithdrawalAmountExceededException;
import exceptions.TooBigWithdrawalAmountException;
import logic.BankAccount;

import java.util.InputMismatchException;

public class CashMachine {
    public static void main(String[] args) {

        Person[] people = {
                new Person("Jadwiga", "Kowalska"),
                new Person("Adam", "Nowak")
        };

        try {
            BankAccount bankAccount = new BankAccount(people[0], 2000.0);
            System.out.println(bankAccount);
            bankAccount.withdrawOrDepositByUserInput();
            System.out.println(bankAccount);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (TooBigWithdrawalAmountException | MaxWithdrawalAmountExceededException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Błędna kwota, spróbuj ponownie.");
        }
    }
}
