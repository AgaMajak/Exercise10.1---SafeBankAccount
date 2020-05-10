package logic;

import data.Person;
import exceptions.MaxWithdrawalAmountExceededException;
import exceptions.TooBigWithdrawalAmountException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    private static final double MAX_WITHDRAWAL_AMOUNT = 1000.0;
    private Person person;
    private double accountBalance;

    public BankAccount(Person person, double accountBalance) throws NullPointerException {
        checkPerson(person);
        this.person = person;
        this.accountBalance = accountBalance;
    }

    private void checkPerson(Person person) {
        if (person == null)
            throw new NullPointerException("Konto musi mieć przypisanego właściciela.");
    }

    private void deposit(double paymentAmount) {
        try {
            if (paymentAmount < 0) {
                throw new IllegalArgumentException("Kwota nie może być mniejsza niż 0.");
            }
            accountBalance += paymentAmount;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void withdraw(double withdrawalAmount) {
        try {
            if (withdrawalAmount > accountBalance) {
                throw new TooBigWithdrawalAmountException(withdrawalAmount, accountBalance);
            } else if (withdrawalAmount > MAX_WITHDRAWAL_AMOUNT) {
                throw new MaxWithdrawalAmountExceededException(withdrawalAmount, MAX_WITHDRAWAL_AMOUNT);
            } else if (withdrawalAmount < 0) {
                throw new IllegalArgumentException("Kwota nie może być mniejsza niż 0.");
            }
            accountBalance -= withdrawalAmount;
        } catch (TooBigWithdrawalAmountException | MaxWithdrawalAmountExceededException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void withdrawOrDepositByUserInput() {
        int i = 0;

        while (i < 1) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Jaką akcję chcesz wykonać? Wpisz: 'wpłać' lub 'wypłać' aby wpłacić, lub wypłacić pieniądze. " +
                        "Wpisz: 'stan konta', aby sprawdzić stan konta. Jeżeli nie chcesz wykonywać żadnej akcji wpisz: 'koniec'.");
                String action = scan.nextLine();
                switch (action) {
                    case "wypłać":
                        System.out.println("Ile chcesz wypłacić?");
                        double withrawalAmount = scan.nextDouble();
                        withdraw(withrawalAmount);
                        break;
                    case "wpłać":
                        System.out.println("Ile chcesz wpłacić?");
                        double paymentAmount = scan.nextDouble();
                        deposit(paymentAmount);
                        break;
                    case "stan konta":
                        System.out.printf("%.2fzł\n", accountBalance);
                        break;
                    case "koniec":
                        i = 1;
                        break;
                    default:
                        System.out.println("Błędnie podane polecenie. Wpisz jeszcze raz.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Błędnie wpisałeś polecenie. Spróbuj jeszcze raz.");
            }
        }
    }


    public String toString() {
        return String.format("Właściciel konta: %s %s. Stan konta: %.2fzł", person.getFirstName(), person.getLastName(), accountBalance);
    }
}
