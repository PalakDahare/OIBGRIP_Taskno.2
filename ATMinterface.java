import java.util.Scanner;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ATMinterface {
    public static void main(String[] args) throws Exception {
        Account current = new Account();
        current.setType("Current");
        current.setBalance(5000.00);
        current.setRate(0.00);

        Account savings = new Account();
        savings.setType("Savings");
        savings.setBalance(100000.00);
        savings.setRate(2.00);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner sc = new Scanner(System.in);

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Welcome to Automated Teller Machine!");
        System.out.println("Kindly Enter your UserId");
        String Name = sc1.nextLine();
        System.out.println("Kindly Enter your 4-digit Pin");
        int Pin = sc1.nextInt();

        int balance = 10000, withdraw, deposit;
        Scanner sc2 = new Scanner(System.in);
        boolean session = true;
        while (session) {
            System.out.println("Welcome");
            System.out.println("ATM Menu:");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 to Check Balance");
            System.out.println("Choose 4 to know your Transaction History");
            System.out.println("Choose 5 to EXIT");
            System.out.print("Choose the operation you want to perform");
            int choice = sc2.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter (1) for Savings or (2) for current: ");
                    int witAccount = sc.nextInt();
                    if (witAccount == 1) {
                        System.out.println("Enter money to be Withdrawn from your Savings Account: ");
                        withdraw = sc2.nextInt();
                        if (withdraw > balance) {
                            System.out.println("Insufficient Balance!! Kindly maintain an Average Balance.");
                        } else {
                            System.out.println("Kindly Collect your Cash");
                        }
                    } else if (witAccount == 2) {
                        if (witAccount == 1) {
                            System.out.println("Enter money to be Withdrawn from your Cuuent Account: ");
                            withdraw = sc2.nextInt();
                            if (withdraw > balance) {
                                System.out.println("Insufficient Balance!! Kindly maintain an Average Balance.");
                            } else {
                                System.out.println("Kindly Collect your Cash");
                            }
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.print("\nEnter (1) for Savings or (2) for Current: ");
                    int depAccount = sc.nextInt();
                    if (depAccount == 1) {
                        System.out.println("Enter the amount to be deposited in your Savings Account");
                        deposit = sc2.nextInt();
                        balance = balance + deposit;
                        System.out.println("Your Amount has been successfully deposited");
                    } else if (depAccount == 2) {
                        System.out.println("Enter the amount to be deposited in your Current Account");
                        deposit = sc2.nextInt();
                        balance = balance + deposit;
                        System.out.println("Your Amount has been successfully deposited");
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("\ncurrent Balance: " + formatter.format(current.getBalance()));
                    System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");

                    break;
                case 4:
                    System.out.print("\nEnter (1) for Savings or (2) for Current: ");
                    int tranAccount = sc.nextInt();
                    if (tranAccount == 1) {
                        System.out.println("Please enter the Transaction Date");
                        System.out.println("dd-mm-yyyy");
                        Scanner scanner = new Scanner(System.in);
                        String date = scanner.nextLine();
                        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                        System.out.println(date1);
                        System.out.println(
                                "Your transaction History in your Savings Account on " + date1 + " is as follows:");
                        System.out.println("Balance:" + balance);
                    } else if (tranAccount == 2) {
                        System.out.println("Please enter the Transaction Date");
                        System.out.println("dd-mm-yyyy");
                        Scanner scanner = new Scanner(System.in);
                        String date = scanner.nextLine();
                        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                        System.out.println(date1);
                        System.out.println(
                                "Your transaction History in your Current Account on " + date1 + " is as follows:");
                        System.out.println("Balance:" + balance);
                    }
                    System.out.println("");
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
            System.out.println("Thank you. Have a nice Day!!");
        }

    }
}
