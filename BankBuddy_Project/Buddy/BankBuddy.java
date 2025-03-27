package Buddy;

import java.sql.*;
import java.util.*;

public class BankBuddy {

    static void run2(String message) {

        String s1[] = message.split("");

        for (String s : s1) {
            System.out.print(s);
            try {
                Thread.sleep(30);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        try {

            String dburl = "jdbc:mysql://localhost:3306/bankbuddy";
            String dbuser = "root";
            String dbpass = "";
            String driver = "com.mysql.cj.jdbc.Driver";

            Class.forName(driver);
            Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

            Link l1 = new Link();

            Scanner sc = new Scanner(System.in);

            System.out.println();

            String s1 = "------------------------------------\n";
            String s2 = "| Welcome To Bank Buddy Management |\n";
            String s3 = "------------------------------------\n";

            run2(s1);
            run2(s2);
            run2(s3);

            String botRespones = "Bot: Hello! How can I help you today? \n";
            String botWorks = "Bot: I can assist you with various banking tasks. If want then type bank \n";
            String botBye = "Bot: Goodbye! If you need help in the future, feel free to reach out. Have a great day! \n";
            String botFailed = "Bot: I'm sorry, I didn't understand that. Can you please specify your query? \n";

            run2(botRespones);
            run2(botWorks);

            String me = "Enter Your Message: ";
            run2(me);
            String message = sc.nextLine();

            boolean work = true;
            while (work) {

                if (message.toLowerCase().contains("hi")) {
                    run2(botRespones);
                } else if (message.toLowerCase().contains("bye")) {
                    run2(botBye);
                } else if (message.toLowerCase().contains("bank")) {
                    menu(con, sc, l1);
                } else if (message.toLowerCase().contains("")) {
                    run2(botFailed);
                    work = false;
                } else {
                    run2(botFailed);
                    work = false;
                }

            }
        } catch (Exception e) {
            System.out.println("\nBot: Error!!");
        }
    }

    public static void menu(Connection con, Scanner sc, Link l1) {

        try {
            String botBye = "Bot: Goodbye! If you need help in the future, feel free to reach out. Have a great day! \n Bot: Thank you for the coming...!";
            boolean b = true;

            while (b) {

                String mess1 = "\nBot: Enter 1. To Go Account Management \n     Enter 2. To Go Transaction Management \n     Enter 3. To Go Loan Management \n     ";
                String mess2 = "Enter 4. To Go Admin \n     Enter 5. To Exit";

                run2(mess1);
                run2(mess2);

                System.out.print("\nBot: Enter Your Choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:

                        AccountsManagement(con, l1, sc);
                        break;
                    case 2:

                        TransactionsManagement(con, sc);
                        break;
                    case 3:

                        LoansManagement(con, sc);
                        break;
                    case 4:

                        break;
                    case 5:

                        run2(botBye);
                        b = false;

                        return;
                    default:
                        break;
                }
            }
        } catch (Exception e) {

            System.out.println("Bot: Error!! " + e);
        }
    }

    static void AccountsManagement(Connection con, Link l1, Scanner sc) {

        try {
            AccountMangement a = new AccountMangement();

            while (true) {

                String mess1 = "\nBot: Enter 1. To Open Account\n     Enter 2. To Update Account\n     Enter 3. To Delete Account\n     ";
                String mess2 = "Enter 4. To Display Saving Account Details\n     Enter 5. To Display Currnet Account Details\n     Enter 6. To Exit";

                run2(mess1);
                run2(mess2);

                System.out.print("\nBot: Enter Your Choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        a.openNewBankAccount(sc, con);
                        break;

                    case 2:
                        a.updateAccount(sc, con);
                        break;

                    case 3:
                        a.deleteAccount(sc, con);
                        break;

                    case 4:
                        a.displaySavingAccountDetails(sc, con);
                        break;

                    case 5:
                        a.displayCurrentAccountDetails(sc, con);
                        break;

                    case 6:
                        System.out.println("Bot: Exit...");
                        return;

                    default:
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Bot: Error!! " + e);
        }
    }

    static void TransactionsManagement(Connection con, Scanner sc) {

        try {
            AccountMangement a = new AccountMangement();

            while (true) {

                String mess1 = "\nBot: Enter 1. To Tarnfar Money\n     Enter 2. To Withdow Money\n     Enter 3. To Deposit Money\n     ";
                String mess2 = "Enter 4. To Check Bank Balance\n     Enter 5. To Transaction History\n     Enter 6. To Exit";

                run2(mess1);
                run2(mess2);

                System.out.print("\nBot: Enter Your Choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        a.transfarMoney(sc, con);
                        break;

                    case 2:
                        a.withdowMoney(sc, con);
                        break;

                    case 3:
                        a.depositMoney(sc, con);
                        break;

                    case 4:
                        a.checkBankBlance(sc, con);
                        break;

                    case 5:
                        a.transtionHistory(sc, con);
                        break;

                    case 6:
                        System.out.println("Bot: Exit...");
                        return;

                    default:
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Bot: Error!! " + e);
        }
    }

    static void LoansManagement(Connection con, Scanner sc) {

        try {
            AccountMangement a = new AccountMangement();

            while (true) {

                String mess1 = "\nBot: Enter 1. To Personal Loan\n     Enter 2. To Eduction Loan\n     ";
                String mess2 = "Enter 3. To Business Loan\n     Enter 4. To Exit";

                run2(mess1);
                run2(mess2);

                System.out.print("\nBot: Enter Your Choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        a.personalLoan(sc, con);
                        break;

                    case 2:
                        a.educationLoan(sc, con);
                        break;

                    case 3:
                        a.businessLoan(sc, con);
                        break;

                    case 4:
                        System.out.println("Bot: Exit...");
                        return;

                    default:
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Bot: Error!! " + e);
        }
    }

    static void Admin(Connection con, Scanner sc, Link l1) {

        try {

            System.out.print("Enter Id: ");
            String id = sc.nextLine();

            System.out.println("Enter Passward: ");
            String password = sc.nextLine();

            if (id.equalsIgnoreCase("admin@bankbuddy") && password.equalsIgnoreCase("bankbuddy@1234")) {

                AccountMangement a = new AccountMangement();

                while (true) {

                    String mess1 = "\nBot: Enter 1. To Account Management\n     Enter 2. To Transaction Management\n     Enter 3. To Loan Mangement\n     ";
                    String mess2 = "Enter 4. To Loan Management\n     Enter 5. To Display All Account Number And Pin\n     Enter 6. To Exit";

                    run2(mess1);
                    run2(mess2);

                    System.out.print("\nBot: Enter Your Choice: ");
                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {
                        case 1:
                            AccountsManagement(con, l1, sc);
                            break;

                        case 2:
                            a.educationLoan(sc, con);
                            break;

                        case 3:
                            a.businessLoan(sc, con);
                            break;

                        case 4:
                            a.displayAccountPin(l1);
                            break;

                        case 5:

                            System.out.print("\nEnter  Account Number: ");
                            long AccNo = sc.nextLong();
                            sc.nextLine();

                            System.out.print("Enter  Account Pin: ");
                            int Pin = sc.nextInt();
                            sc.nextLine();

                            a.accountNumberExits(l1, AccNo, Pin);
                        case 6:
                            System.out.println("Bot: Exit...");
                            return;

                        default:
                            break;
                    }
                }
            } else {

                System.out.println("Bot: Error! Invaild Id & Password!!");
            }
        } catch (Exception e) {
            System.out.println("Bot: Error!! " + e);
        }

    }
}
