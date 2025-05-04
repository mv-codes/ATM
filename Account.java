import java.util.Scanner;

public class Account {

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    public Account(String cname, String cid) {

        customerName = cname;
        customerID = cid;
    }
    void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {

        char option = '\0';
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("ID: " + customerID);
        System.out.println("\nA: Check Balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw");
        System.out.println("D: Previous Transaction");
        System.out.println("E: Exit");

        do {

            System.out.println("--------------------------------------------------------------");
            System.out.println("Please enter A, B, C, D, or E to select an option from above: ");
            System.out.println("--------------------------------------------------------------");
            option = input.next().charAt(0);
            System.out.println("\n");

            switch(option) {

                case 'A':
                    System.out.println("Balance: " + balance);
                    break;

                case 'B':
                    System.out.println("Enter Deposit Amount: ");
                    int amount = input.nextInt();
                    deposit(amount);
                    break;

                case 'C':
                    System.out.println("Enter amount to withdraw: ");
                    int amount2 = input.nextInt();
                    withdraw(amount2);
                    break;

                case 'D':
                    getPreviousTransaction();
                    break;

                case 'E':
                    System.out.println("Thank You");
                    System.out.println("Your session has ended.");


                default:
                    System.out.println("Invalid Option. Please enter again: ");
                    break;
            }

        } while (option != 'E');






    }
}
