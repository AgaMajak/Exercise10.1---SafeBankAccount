import data.Person;
import logic.BankAccount;

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
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
