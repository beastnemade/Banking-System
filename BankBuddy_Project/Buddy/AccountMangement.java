package Buddy;

import java.util.*;
import java.io.*;
import java.sql.*;

public class AccountMangement {

    class print extends Thread {

        String message;

        public print(String message) {
            this.message = message;
        }

        void run1() {
            String s1[] = message.split("");

            System.out.print("\nBot: ");
            for (String s : s1) {
                System.out.print(s);
                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }

    print p;

    String firstName, middelName, lastName;
    String address, mobileNumber, email, DOB;
    String addharNumbeer, panNumber;
    String cap, captcha, businessType;
    String gstno, addharno;
    String businessName, gstNumber, businessAddress;
    long accountNumber;
    double annualTurnover, balance;
    int pin;

    void openNewBankAccount(Scanner sc, Connection con) throws Exception {

        while (true) {

            String botacc = "Enter 1. To Open Saving Account \n     Enter 2. To Open Current Account \n     Enter 3. To Exit";
            String tupeacc = "Enter Account Type: ";

            p = new print(botacc);
            p.run1();

            p = new print(tupeacc);
            p.run1();

            int type = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                String mess1 = "Bot: Okk! So We Open New Saving Account ";
                p = new print(mess1);
                p.run1();

                openSavingAccount(sc, con);

            } else if (type == 2) {

                String mess2 = "Bot: Okk! So We Open New Currnet Account ";
                p = new print(mess2);
                p.run1();

                openCurrentAccount(sc, con);
            } else if (type == 3) {
                return;
            } else {
                System.out.println("Bot: Error! Invaild Choice!!");
            }
        }
    }

    void openSavingAccount(Scanner sc, Connection con) throws Exception {

        String botDet = "----- Enter Your Personal Details -----\n";
        p = new print(botDet);
        p.run1();

        System.out.print("\nEnter Your First Name: ");
        firstName = sc.nextLine();

        System.out.print("Enter Your Middle Name: ");
        middelName = sc.nextLine();

        System.out.print("Enter Your Last Name: ");
        lastName = sc.nextLine();

        System.out.print("Enter Your Date Of Brith [DD-MM-YYYY]: ");
        DOB = sc.nextLine();

        System.out.print("Enter Your Mobile Number: ");
        mobileNumber = sc.nextLine();

        System.out.print("Enter Your Email Id: ");
        email = sc.nextLine();

        System.out.print("Enter Your Address: ");
        address = sc.nextLine();

        System.out.print("Enter Your Addhar Card Number: ");
        addharNumbeer = sc.nextLine().toUpperCase();

        System.out.print("Enter Your Pan Card Number: ");
        panNumber = sc.nextLine();

        System.out.print("Enter Intital Bank Account Balance: ");
        balance = sc.nextDouble();
        sc.nextLine();

        String checkmess = "Bot: Please Wait Checking Your Details";
        p = new print(checkmess);
        p.run1();

        for (int i = 0; i <= 5; i++) {
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();
        checkDetails(firstName, middelName, lastName, DOB, mobileNumber, email, address, addharNumbeer, panNumber,
                balance, sc,
                con);

    }

    void openCurrentAccount(Scanner sc, Connection con) throws Exception {

        String botDe = "----- Enter Business Details -----\n";
        p = new print(botDe);
        p.run1();

        System.out.print("\nEnter Business Name: ");
        businessName = sc.nextLine();

        System.out.print("Enter Business Type: ");
        businessType = sc.nextLine();

        System.out.print("Enter Business GST Number: ");
        gstNumber = sc.nextLine().toUpperCase();

        System.out.print("Enter Business Address: ");
        businessAddress = sc.nextLine();

        System.out.print("Enter Business Annual Turnover: ");
        annualTurnover = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Owner First Name: ");
        firstName = sc.nextLine();

        System.out.print("Enter Owner Middel Name: ");
        middelName = sc.nextLine();

        System.out.print("Enter Owner Last Name: ");
        lastName = sc.nextLine();

        System.out.print("Enter Your Addhar Card Number: ");
        addharNumbeer = sc.nextLine().toUpperCase();

        String checkbussmess = "Please Wait Checking Business Details";
        p = new print(checkbussmess);
        p.run1();

        for (int i = 0; i <= 5; i++) {
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println();
        checkBusinessDetails(businessName, businessType, gstNumber, businessAddress, annualTurnover, firstName,
                middelName, lastName, addharNumbeer, sc, con);

        String botDet = "----- Enter Business Owner Personal Details -----\n";

        p = new print(botDet);
        p.run1();

        System.out.print("Enter Your Date Of Brith: ");
        DOB = sc.nextLine();

        System.out.print("Enter Your Mobile Number: ");
        mobileNumber = sc.nextLine();

        System.out.print("Enter Your Email Id: ");
        email = sc.nextLine();

        System.out.print("Enter Your Address: ");
        address = sc.nextLine();

        System.out.print("Enter Your Pan Card Number: ");
        panNumber = sc.nextLine();

        System.out.print("Enter Intital Bank Account Balance: ");
        balance = sc.nextDouble();
        sc.nextLine();

        String checkownmess = "Please Wait Checking Business Owner Details";
        p = new print(checkownmess);
        p.run1();

        for (int i = 0; i <= 5; i++) {
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();
        checkDetails(firstName, middelName, lastName, DOB, mobileNumber, email, address, addharNumbeer, panNumber,
                balance, sc, con);

    }

    void checkDetails(String firstName, String middelName, String lastName, String DOB, String moblieNumber,
            String email, String address, String addharNumber, String panNumber, double amount, Scanner sc,
            Connection con) throws Exception {

        System.out.println();
        while (firstName == null || firstName.trim().equals("")) {
            System.out.print("Please Enter Vaild First Name: ");
            firstName = sc.nextLine();
        }

        while (middelName == null || middelName.trim().equals("")) {
            System.out.print("Please Enter Vaild Middle Name: ");
            middelName = sc.nextLine();
        }

        while (lastName == null || lastName.trim().equals("")) {
            System.out.print("Please Enter Vaild Last Name: ");
            lastName = sc.nextLine();
        }

        boolean f = true;
        while (f) {

            String[] d = DOB.split("-");

            if (d.length != 3) {
                System.out.print("Please Enter Valid Date In [DD-MM-YYYY] format.");
                DOB = sc.nextLine();
            }
            int day = Integer.parseInt(d[0]);
            int month = Integer.parseInt(d[1]);
            int year = Integer.parseInt(d[2]);

            if (isValidDate(day, month, year)) {
                f = false;
            } else {
                System.out.println("Date of Birth is invalid.");
            }
        }

        for (int i = 0; i < moblieNumber.length(); i++) {

            while (moblieNumber.charAt(i) < '0' || moblieNumber.charAt(i) > '9' || moblieNumber.length() < 10
                    || moblieNumber.length() > 10) {
                System.out.print("Please Enter 10 Digits Phone Number: ");
                moblieNumber = sc.nextLine();
            }
        }

        boolean flag = false;
        while (true) {

            email = email.trim();

            int atIndex = email.indexOf('@');
            if (atIndex < 1) {
                flag = false;
            }

            int dotIndex = email.indexOf('.', atIndex);

            if (dotIndex <= atIndex + 1 || dotIndex == email.length() - 1) {
                flag = false;
            } else {
                flag = true;
            }

            if (flag) {
                break;
            } else {
                System.out.print("Please Enter Vaild Email Id : ");
                email = sc.nextLine().trim();
            }
        }

        while (address == null || address.trim().equals("")) {
            System.out.print("Please Enter Vaild Address: ");
            address = sc.nextLine();
        }

        for (int i = 0; i < addharNumber.length(); i++) {

            while (addharNumber == null || addharNumber.trim().equals("") || addharNumber.charAt(i) < '0'
                    || addharNumber.charAt(i) > '9' || addharNumber.length() < 12 || addharNumber.length() > 12) {
                System.out.print("Please Enter 12 Digits Aadhar Number: ");
                addharNumber = sc.nextLine();
            }

        }

        panNumber = panNumber.trim().toUpperCase();

        while (panNumber == null || panNumber.length() != 10) {
            System.out.print("Please Enter a Valid PAN Number: ");
            panNumber = sc.nextLine().trim().toUpperCase();
        }

        for (int j = 0; j < 5; j++) {
            while (panNumber.charAt(j) < 'A' || panNumber.charAt(j) > 'Z') {
                System.out.print("Please Enter a Valid PAN Number: ");
                panNumber = sc.nextLine().trim().toUpperCase();
            }
        }

        for (int j = 5; j < 9; j++) {
            while (panNumber.charAt(j) < '0' || panNumber.charAt(j) > '9') {
                System.out.print("Please Enter a Valid PAN Number: ");
                panNumber = sc.nextLine().trim().toUpperCase();
            }
        }

        while (panNumber.charAt(9) < 'A' || panNumber.charAt(9) > 'Z') {
            System.out.print("Please Enter a Valid PAN Number: ");
            panNumber = sc.nextLine().trim().toUpperCase();
        }

        while (amount == 0 || amount < 0) {

            System.out.println("Please Enter Vaild Amount: ");
            amount = sc.nextDouble();
            sc.nextLine();
        }

        System.out.println("Bot: All Details Are Vaild!");

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag1 = true;

        while (flag1) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag1 = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        accountNumber = generateAccountNumber();
        pin = generatePinNumber();

        Link l1 = new Link();
        l1.insertAtLast(accountNumber, pin);

        String fullName = firstName + " " + middelName + " " + lastName;

        String sql = "insert into savingaccount (accountNumber, pin, fullName, DOB, mobileNumber, email, address, addharNumbeer, panNumber, balance) values(?, ?, ?, ?, ? , ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1, accountNumber);
        pst.setInt(2, pin);
        pst.setString(3, fullName);
        pst.setString(4, DOB);
        pst.setString(5, mobileNumber);
        pst.setString(6, email);
        pst.setString(7, address);
        pst.setString(8, addharNumbeer);
        pst.setString(9, panNumber);
        pst.setDouble(10, amount);

        int r = pst.executeUpdate();
        if (r > 0) {
            System.out.println("\nBot: Saving Account Open Successfully!!");
        } else {
            System.out.println("Bot: Saving Account Open Failed!!");
        }

        System.out.println("\nBot: ");
        System.out.print("Your Account Number: " + accountNumber);
        System.out.println("    Your Account Pin: " + pin);
        System.out.println("    Bank IFC Code: " + ifcCode);

        String fileName = fullName + ".txt";
        File f1 = new File(fileName);
        f1.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(f1, true));

        bw.write("----------------------------------------------------");
        bw.write("Full Name: " + fullName);
        bw.write("Date Fo Birht: " + DOB);
        bw.write("Mobile Number: " + moblieNumber);
        bw.write("Email: " + email);
        bw.write("Address: " + address);
        bw.write("Addhar Card Number: " + addharNumber);
        bw.write("Pan Card Number: " + panNumber);
        bw.write("Balance: " + balance);
        bw.write("----------------------------------------------------");
        bw.newLine();

        bw.close();
    }

    void checkBusinessDetails(String businessName, String businessType, String gstNumber, String businessAddress,
            double annualTurnover, String firstName, String middelName, String lastName, String addharNumber,
            Scanner sc, Connection con) throws Exception {

        System.out.println();

        while (businessName == null || businessName.trim().equals("")) {
            System.out.print("Please Enter Vaild Business Name: ");
            businessName = sc.nextLine();

        }

        while (businessType == null || businessType.trim().equals("")) {
            System.out.print("Please Enter Vaild Business Type: ");
            businessType = sc.nextLine();

        }
        while (gstNumber == null || gstNumber.trim().equals("")) {
            System.out.print("Please Enter Vaild Business GST Number: ");
            gstNumber = sc.nextLine();

        }

        gstNumber = gstNumber.trim();

        while (gstNumber == null || gstNumber.length() != 15) {
            System.out.print("Please Enter a Valid GST Number: ");
            gstNumber = sc.nextLine().trim().toUpperCase();
            if (gstNumber.length() == 15)
                break;
        }

        for (int j = 0; j < 2; j++) {
            while (gstNumber.charAt(j) < '0' || gstNumber.charAt(j) > '9') {
                System.out.print("Please Enter a Valid GST Number: ");
                gstNumber = sc.nextLine().trim().toUpperCase();
            }
        }

        for (int j = 2; j < 7; j++) {
            while (gstNumber.charAt(j) < 'A' || gstNumber.charAt(j) > 'Z') {
                System.out.print("Please Enter a Valid GST Number: ");
                gstNumber = sc.nextLine().trim().toUpperCase();
            }
        }

        for (int j = 7; j < 11; j++) {
            while (gstNumber.charAt(j) < '0' || gstNumber.charAt(j) > '9') {
                System.out.print("Please Enter a Valid GST Number: ");
                gstNumber = sc.nextLine().trim().toUpperCase();
            }
        }

        while (gstNumber.charAt(11) < 'A' || gstNumber.charAt(11) > 'Z') {
            System.out.print("Please Enter a Valid GST Number: ");
            gstNumber = sc.nextLine().trim().toUpperCase();
        }

        while (gstNumber.charAt(12) < '0' || gstNumber.charAt(12) > '9' || gstNumber.charAt(14) < '0'
                || gstNumber.charAt(14) > '9') {

            System.out.print("Please Enter a Valid GST Number: ");
            gstNumber = sc.nextLine().trim().toUpperCase();
            if (gstNumber.length() == 15)
                break;
        }

        while (gstNumber.charAt(13) != 'Z') {
            System.out.print("Please Enter a Valid GST Number: ");
            gstNumber = sc.nextLine().trim().toUpperCase();
        }

        while (businessAddress == null || businessAddress.trim().equals("")) {
            System.out.print("Please Enter Vaild Business Address: ");
            businessAddress = sc.nextLine();

        }

        while (annualTurnover == 0 || annualTurnover < 0) {
            System.out.println("Please Enter Vaild Business Annual Turnover: ");
            annualTurnover = sc.nextDouble();
        }

        while (firstName == null || firstName.trim().equals("")) {
            System.out.print("Please Enter Vaild First Name: ");
            firstName = sc.nextLine();
        }

        while (middelName == null || middelName.trim().equals("")) {
            System.out.print("Please Enter Vaild Middle Name: ");
            middelName = sc.nextLine();
        }

        while (lastName == null || lastName.trim().equals("")) {
            System.out.print("Please Enter Vaild Last Name: ");
            lastName = sc.nextLine();
        }

        for (int i = 0; i < addharNumber.length(); i++) {

            while (addharNumber == null || addharNumber.trim().equals("") || addharNumber.charAt(i) < '0'
                    || addharNumber.charAt(i) > '9' || addharNumber.length() < 12 || addharNumber.length() > 12) {
                System.out.print("Please Enter 12 Digits Aadhar Number: ");
                addharNumber = sc.nextLine();
            }

        }

        System.out.println("All Business Details Are Vaild!");

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();

        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag = true;

        while (flag) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        String oewnerName = firstName + " " + middelName + " " + lastName;

        String sql = "insert into currentaccount(businessName, businessType, gstNumber, businessAddress, annualTurnover, ownerName, addharNumber) values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, businessName);
        pst.setString(2, businessType);
        pst.setString(3, gstNumber);
        pst.setString(4, businessAddress);
        pst.setDouble(5, annualTurnover);
        pst.setString(6, oewnerName);
        pst.setString(7, addharNumber);

        int r = pst.executeUpdate();
        if (r > 0) {
            System.out.println("\nBot: Account Open Successfully!!");
        } else {
            System.out.println("Bot: Account Open Failed!!");
        }

        String fileName = businessName + ".txt";
        File f1 = new File(fileName);
        f1.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(f1, true));
        bw.write("----------------------------------------------------");
        bw.write("Business Name: " + businessName);
        bw.newLine();
        bw.write("Business Type: " + businessType);
        bw.newLine();
        bw.write("Business GST Number: " + gstNumber);
        bw.newLine();
        bw.write("Business Address: " + businessAddress);
        bw.newLine();
        bw.write("Business Annual Turn Over: " + annualTurnover);
        bw.newLine();
        bw.write("Business Owner Name: " + oewnerName);
        bw.newLine();
        bw.write("Business Owner Addhar Card Number: " + addharNumber);
        bw.newLine();
        bw.write("----------------------------------------------------");
        bw.newLine();

        bw.close();

    }

    boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    boolean isValidDate(int day, int month, int year) {

        if (year < 1900 || year > 2024) {
            return false;
        }

        // Days in each month
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Adjust February days for leap years
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Check if month is valid
        if (month < 1 || month > 12) {
            return false;
        }

        // Check if day is valid for the given month
        if (day < 1 || day > daysInMonth[month - 1]) {
            return false;
        }

        return true;
    }

    Long generateAccountNumber() {

        Long accountNumber = (long) (Math.random() * 999999999999L);
        return accountNumber;
    }

    int generatePinNumber() {

        int pinNumber = (int) (Math.random() * 9999);
        return pinNumber;
    }

    char getRandomUppercaseLetter() {
        return (char) ('A' + (int) (Math.random() * 26));
    }

    char getRandomLowercaseLetter() {
        return (char) ('a' + (int) (Math.random() * 26));
    }

    int getRandomNumber() {
        return (int) (Math.random() * 99);
    }

    boolean checkAccountNumber(long accountNumber, int pin, Connection con) throws Exception {

        String sql = "select * from savingaccount where accountNumber = ? and pin = ? ";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1, accountNumber);
        pst.setInt(2, pin);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkCurrAccountNumber(long accountNumber, int pin, String gstno, String addharno, Connection con)
            throws Exception {

        String sql1 = "select * from savingaccount where accountNumber = ? and pin = ?";
        PreparedStatement pst1 = con.prepareStatement(sql1);

        String sql2 = "select * from currentaccount where gstNumber = ? and addharNumber = ?";
        PreparedStatement pst2 = con.prepareStatement(sql2);

        pst1.setLong(1, accountNumber);
        pst1.setInt(2, pin);

        pst2.setString(1, gstno);
        pst2.setString(2, addharno);

        ResultSet rs1 = pst1.executeQuery();
        ResultSet rs2 = pst2.executeQuery();

        if (rs1.next() && rs2.next()) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkBusinessNumber(String buName, String gstnumber, Connection con) throws Exception {

        String sql = "select * from currentaccount where businessName = ? and gstNumber = ? ";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, buName);
        pst.setString(2, gstnumber);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    void updateAccount(Scanner sc, Connection con) throws Exception {

        while (true) {

            String botacc = "Enter 1. To Update On Saving Account \n     Enter 2. To Update On Current Account \n     Enter 3. To Exit\n";

            p = new print(botacc);
            p.run1();

            System.out.print("\nBot: Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                String mess = "Bot: Okk! So We Update On Saving Account ";
                p = new print(mess);
                p.run1();

                updateSavingAccount(sc, con);
            } else if (choice == 2) {

                String mess = " Okk! So We Open New Currnet Account ";
                p = new print(mess);
                p.run1();

                updateCurrnetAccount(sc, con);
            } else if (choice == 3) {

                return;
            } else {

                System.out.println("Bot: Error! Invaild Choice!!");
            }
        }
    }

    void updateSavingAccount(Scanner sc, Connection con) throws Exception {

        String botDet = "----- Enter Your Personal Details -----\n";
        p = new print(botDet);
        p.run1();

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        pin = sc.nextInt();
        sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag = true;

        while (flag) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        if (checkAccountNumber(accountNumber, pin, con)) {

            String botDe = "----- Enter Your New Personal Details -----\n";
            p = new print(botDe);
            p.run1();

            System.out.print("\nEnter Your First Name : ");
            firstName = sc.nextLine();

            System.out.print("Enter Your Middle Name: ");
            middelName = sc.nextLine();

            System.out.print("Enter Your Last Name: ");
            lastName = sc.nextLine();

            System.out.print("Enter Your DOB: ");
            DOB = sc.nextLine();

            System.out.print("Enter Your Mobile Number: ");
            mobileNumber = sc.nextLine();

            System.out.print("Enter Your Email Id: ");
            email = sc.nextLine();

            System.out.print("Enter Your Address: ");
            address = sc.nextLine();

            while (firstName == null || firstName.trim().equals("")) {
                System.out.print("Please Enter Vaild First Name: ");
                firstName = sc.nextLine();
            }

            while (middelName == null || middelName.trim().equals("")) {
                System.out.print("Please Enter Vaild Middle Name: ");
                middelName = sc.nextLine();
            }

            while (lastName == null || lastName.trim().equals("")) {
                System.out.print("Please Enter Vaild Last Name: ");
                lastName = sc.nextLine();
            }

            boolean f = true;
            while (f) {

                String[] d = DOB.split("-");

                if (d.length != 3) {
                    System.out.print("Please Enter Valid Date In [DD-MM-YYYY] format.");
                    DOB = sc.nextLine();
                }
                int day = Integer.parseInt(d[0]);
                int month = Integer.parseInt(d[1]);
                int year = Integer.parseInt(d[2]);

                if (isValidDate(day, month, year)) {
                    f = false;
                } else {
                    System.out.println("Date of Birth is invalid.");
                }
            }

            for (int i = 0; i < mobileNumber.length(); i++) {

                while (mobileNumber.charAt(i) < '0' || mobileNumber.charAt(i) > '9' || mobileNumber.length() < 10
                        || mobileNumber.length() > 10) {
                    System.out.print("Please Enter 10 Digits Phone Number: ");
                    mobileNumber = sc.nextLine();
                }
            }

            boolean flag1 = false;
            while (true) {

                email = email.trim();

                int atIndex = email.indexOf('@');
                if (atIndex < 1) {
                    flag1 = false;
                }

                int dotIndex = email.indexOf('.', atIndex);

                if (dotIndex <= atIndex + 1 || dotIndex == email.length() - 1) {
                    flag1 = false;
                } else {
                    flag1 = true;
                }

                if (flag1) {
                    break;
                } else {
                    System.out.print("Please Enter Vaild Email Id : ");
                    email = sc.nextLine().trim();
                }
            }

            while (address == null || address.trim().equals("")) {
                System.out.print("Please Enter Vaild Address: ");
                address = sc.nextLine();
            }

            System.out.println("Bot: All Details Are Vaild!");

            String fName = firstName + " " + middelName + " " + lastName;

            // String sql = "update savingaccount set fullName = ? , DOB = ?, mobileNumber =
            // ?, email = ?, address= ? where accountNumber = ? and pin = ?";
            String sql = "{ call updatesavingaccount(?, ?, ?, ?, ?, ? , ?) }";

            CallableStatement cst = con.prepareCall(sql);

            cst.setString(1, fName);
            cst.setString(2, DOB);
            cst.setString(3, mobileNumber);
            cst.setString(4, email);
            cst.setString(5, address);
            cst.setLong(6, accountNumber);
            cst.setInt(7, pin);

            int r = cst.executeUpdate();
            if (r > 0) {
                System.out.println("\nBot: Account Updated successfull!!");
            } else {
                System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
                return;
            }

            String fileName = businessName + ".txt";
            File f1 = new File(fileName);
            f1.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f1, true));
            bw.write("----------------------------------------------------");
            bw.write("Business Name: " + businessName);
            bw.newLine();
            bw.write("Business Type: " + businessType);
            bw.newLine();
            bw.write("Business GST Number: " + gstNumber);
            bw.newLine();
            bw.write("Business Address: " + businessAddress);
            bw.newLine();
            bw.write("Business Annual Turn Over: " + annualTurnover);
            bw.newLine();
            bw.write("----------------------------------------------------");
            bw.newLine();

            bw.close();
        } else {

            System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
            return;
        }
    }

    void updateCurrnetAccount(Scanner sc, Connection con) throws Exception {

        String botDe = "----- Enter Business Details -----\n";
        p = new print(botDe);
        p.run1();

        System.out.print("Enter Business Account Number: ");
        accountNumber = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Business Account Pin: ");
        pin = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Buiness GST Number: ");
        gstno = sc.nextLine().toUpperCase();

        System.out.print("Enter Owner Addhar Card Number: ");
        addharno = sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag = true;

        while (flag) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        if (checkCurrAccountNumber(accountNumber, pin, gstno, addharno, con)) {

            String botd = "----- Enter Your New Business Details -----\n";
            p = new print(botd);
            p.run1();

            System.out.print("Enter Business New Name: ");
            businessName = sc.nextLine();

            System.out.println("Enter Business New Type: ");
            businessType = sc.nextLine();

            System.out.println("Enter Business New Annual Turnover: ");
            annualTurnover = sc.nextDouble();
            sc.nextLine();

            String botde = "----- Enter Your New Personal Details -----\n";
            p = new print(botde);
            p.run1();

            System.out.print("\nEnter Your First Name: ");
            firstName = sc.nextLine();

            System.out.print("Enter Your Middle Name: ");
            middelName = sc.nextLine();

            System.out.print("Enter Your Last Name: ");
            lastName = sc.nextLine();

            System.out.print("Enter Your DOB: ");
            DOB = sc.nextLine();

            System.out.print("Enter Your Mobile Number: ");
            mobileNumber = sc.nextLine();

            System.out.print("Enter Your Email Id: ");
            email = sc.nextLine();

            System.out.print("Enter Your Address: ");
            address = sc.nextLine();

            while (businessName == null || businessName.trim().equals("")) {
                System.out.print("Please Enter Vaild Business Name: ");
                businessName = sc.nextLine();
            }

            while (businessType == null || businessType.trim().equals("")) {
                System.out.print("Please Enter Vaild Business Type: ");
                businessType = sc.nextLine();
            }

            while (annualTurnover == 0 || annualTurnover < 0) {

                System.out.println("Please Enter Vaild Annual Turn Over: ");
                annualTurnover = sc.nextDouble();
            }
            System.out.println("Bot: All Business Details Are Vaild!");

            while (firstName == null || firstName.trim().equals("")) {
                System.out.print("Please Enter Vaild First Name: ");
                firstName = sc.nextLine();
            }

            while (middelName == null || middelName.trim().equals("")) {
                System.out.print("Please Enter Vaild Middle Name: ");
                middelName = sc.nextLine();
            }

            while (lastName == null || lastName.trim().equals("")) {
                System.out.print("Please Enter Vaild Last Name: ");
                lastName = sc.nextLine();
            }

            while (balance == 0 || balance < 0) {

                System.out.println("Please Enter Vaild Balance: ");
                balance = sc.nextInt();
            }

            for (int i = 0; i < mobileNumber.length(); i++) {

                while (mobileNumber.charAt(i) < '0' || mobileNumber.charAt(i) > '9' || mobileNumber.length() < 10
                        || mobileNumber.length() > 10) {
                    System.out.print("Please Enter 10 Digits Phone Number: ");
                    mobileNumber = sc.nextLine();
                }
            }

            boolean flag1 = false;
            while (true) {

                email = email.trim();

                int atIndex = email.indexOf('@');
                if (atIndex < 1) {
                    flag1 = false;
                }

                int dotIndex = email.indexOf('.', atIndex);

                if (dotIndex <= atIndex + 1 || dotIndex == email.length() - 1) {
                    flag1 = false;
                } else {
                    flag1 = true;
                }

                if (flag1) {
                    break;
                } else {
                    System.out.print("Please Enter Vaild Email Id : ");
                    email = sc.nextLine().trim();
                }
            }

            while (address == null || address.trim().equals("")) {
                System.out.print("Please Enter Vaild Address: ");
                address = sc.nextLine();
            }

            System.out.println("Bot: All Personl Details Are Vaild!");

            String fName = firstName + " " + middelName + " " + lastName;

            // String sql1 = "update currentaccount set businessName = ?, businessType = ?,
            // annualTurnover = ? WHERE gstNumber = ? and addharNumber = ?";
            String sql1 = "{ call updatecurrnetacc(?, ?, ?, ?, ?) }";
            CallableStatement cst1 = con.prepareCall(sql1);

            cst1.setString(1, businessName);
            cst1.setString(2, businessType);
            cst1.setDouble(3, annualTurnover);
            cst1.setString(4, gstno);
            cst1.setString(5, addharno);
            int r1 = cst1.executeUpdate();

            String sql2 = "{ call updatesavingaccount(?, ?, ?, ?, ?, ? , ?) }";

            CallableStatement cst2 = con.prepareCall(sql2);

            cst2.setString(1, fName);
            cst2.setString(2, DOB);
            cst2.setString(3, mobileNumber);
            cst2.setString(4, email);
            cst2.setString(5, address);
            cst2.setLong(6, accountNumber);
            cst2.setInt(7, pin);

            int r2 = cst2.executeUpdate();
            if (r2 > 0) {
                System.out.println("\nBot: Account Updated successfull!!");
            } else {
                System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
                return;
            }

            if (r1 > 0 && r2 > 0) {
                System.out.println("\nBot: Business Account Details Updated Successfull!!");
            } else {
                System.out.println("\nBot: Business Account Details Updated Failed!!");
                return;
            }

            String fileName = businessName + ".txt";
            File f1 = new File(fileName);
            f1.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f1, true));
            bw.write("----------------------------------------------------");
            bw.write("Business Name: " + businessName);
            bw.newLine();
            bw.write("Business Type: " + businessType);
            bw.newLine();
            bw.write("Business GST Number: " + gstNumber);
            bw.newLine();
            bw.write("Business Address: " + businessAddress);
            bw.newLine();
            bw.write("Business Annual Turn Over: " + annualTurnover);
            bw.newLine();
            bw.write("----------------------------------------------------");
            bw.newLine();

            bw.close();

        } else {
            System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
            return;
        }
    }

    void deleteAccount(Scanner sc, Connection con) throws Exception {

        String mess = "Enter 1. To Delete Saving Account \n     Enter 2. To Delete Current Account \n     Enter 3. To Exit";
        p = new print(mess);
        p.run1();

        System.out.print("\nBot: Enter Your Choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {

            System.out.print("Enter Account Number: ");
            accountNumber = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter Account Pin: ");
            pin = sc.nextInt();
            sc.nextLine();

            cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                    + getRandomUppercaseLetter() + "" + getRandomNumber();
            System.out.println("\nBot: Security Captcha: " + cap);
            System.out.print("Bot: Enter Security Captcha: ");
            captcha = sc.nextLine();

            boolean flag = true;

            while (flag) {

                if (captcha.equals(cap)) {
                    System.out.println("Bot: Verification Suessfully!!");
                    flag = false;
                } else {
                    cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                            + getRandomUppercaseLetter() + "" + getRandomNumber();
                    System.out.println("\nBot: New Security Captcha: " + cap);
                    System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                    captcha = sc.nextLine();
                }
            }

            if (checkAccountNumber(accountNumber, pin, con)) {

                con.setAutoCommit(false);
                String sql = "delete from savingaccount where AccountNumber = ? and pin = ?";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.setLong(1, accountNumber);
                pst.setInt(2, pin);

                int r = pst.executeUpdate();
                System.out.println("Enter 1. To Confrom Delete The Saving Account ");
                System.out.println("Enter 2. To Not Confrom Delete The Saving Account ");
                System.out.print("\nBot: Enter Your Choice: ");
                int n = sc.nextInt();
                sc.nextLine();

                if (n == 1) {
                    con.commit();

                    if (r > 0) {
                        System.out.println("\nBot: Account Deletion successfully!!");
                    }
                } else if (n == 2) {

                    con.rollback();
                    if (r < 0) {
                        System.out.println("\nBot: Account Deletion Failed!!");
                    }
                } else {
                    System.out.println("\nBot: Error!! Invaild Choice");
                }

            } else {
                System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
                return;
            }

        } else if (ch == 2) {

            System.out.print("Enter Business Account Number: ");
            accountNumber = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter Business Account Pin: ");
            pin = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Business GST Number: ");
            String gstnumber = sc.nextLine();

            System.out.print("Enyer Owner Aadhar Card Number: ");
            String addharnumber = sc.nextLine();

            cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                    + getRandomUppercaseLetter() + "" + getRandomNumber();
            System.out.println("\nBot: Security Captcha: " + cap);
            System.out.print("Bot: Enter Security Captcha: ");
            captcha = sc.nextLine();

            boolean flag = true;

            while (flag) {

                if (captcha.equals(cap)) {
                    System.out.println("Bot: Verification Suessfully!!");
                    flag = false;
                } else {
                    cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                            + getRandomUppercaseLetter() + "" + getRandomNumber();
                    System.out.println("\nBot: New Security Captcha: " + cap);
                    System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                    captcha = sc.nextLine();
                }
            }

            boolean b1 = checkAccountNumber(accountNumber, pin, con);
            boolean b2 = checkCurrAccountNumber(accountNumber, pin, gstnumber, addharnumber, con);
            if (b1) {

                if (b2) {
                    con.setAutoCommit(false);
                    String sql1 = "delete from savingaccount where AccountNumber = ? and pin = ?";
                    String sql2 = "delete from currentaccount where gstNumber = ? and addharNumber = ?";

                    PreparedStatement pst1 = con.prepareStatement(sql1);
                    PreparedStatement pst2 = con.prepareStatement(sql2);

                    pst1.setLong(1, accountNumber);
                    pst1.setInt(2, pin);

                    pst2.setString(1, gstnumber);
                    pst2.setString(2, addharnumber);

                    int r1 = pst1.executeUpdate();
                    int r2 = pst2.executeUpdate();

                    System.out.println("Enter 1. To Confrom Delete Current Account ");
                    System.out.println("Enter 2. To Not Confrom Delete Current Account ");

                    System.out.print("\nBot: Enter Your Choice: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    if (n == 1) {
                        con.commit();

                        if (r1 > 0 && r2 < 0) {
                            System.out.println("\nBot: Account Deletion successfully!!");
                        }
                    } else if (n == 2) {

                        con.rollback();
                        if (r1 < 0 && r2 < 0) {
                            System.out.println("\nBot: Account Deletion Failed!!");
                        }
                    } else {
                        System.out.println("\nBot: Error!! Invaild Choice");
                    }
                }
            } else {
                System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
                return;
            }

        } else {
            System.out.println("Bot: Exit");
            return;
        }
    }

    void displaySavingAccountDetails(Scanner sc, Connection con) throws Exception {

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        pin = sc.nextInt();
        sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag = true;

        while (flag) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        if (checkAccountNumber(accountNumber, pin, con)) {

            String sql = "select * from savingaccount where accountNumber = ? and pin = ? ";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, accountNumber);
            pst.setInt(2, pin);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                System.out.println("\n ----- Account Holder Details -----");

                System.out.println("Full Name: " + rs.getString(4));
                System.out.println("Date Fo Birht: " + rs.getString(5));
                System.out.println("Mobile Number: " + rs.getString(6));
                System.out.println("Email: " + rs.getString(7));
                System.out.println("Address: " + rs.getString(8));
                System.out.println("Addhar Card Number: " + rs.getString(9));
                System.out.println("Pan Card Number: " + rs.getString(10));
                System.out.println("Balance: " + rs.getDouble(11));
            }

        } else {
            System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
            return;
        }
    }

    void displayCurrentAccountDetails(Scanner sc, Connection con) throws Exception {

        System.out.print("Enter Business Account Number: ");
        accountNumber = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Business Account Pin: ");
        pin = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Business GST Number: ");
        String gstnumber = sc.nextLine();

        System.out.print("Enyer Owner Aadhar Card Number: ");
        String addharnumber = sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        if (checkCurrAccountNumber(accountNumber, pin, gstnumber, addharnumber, con)) {

            String sql1 = "select * from currentaccount where gstNumber = ? and addharNumber = ? ";

            PreparedStatement pst1 = con.prepareStatement(sql1);
            pst1.setString(1, gstnumber);
            pst1.setString(2, addharnumber);

            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next()) {

                System.out.println("\n ----- Business Details -----");

                System.out.println("Business Name: " + rs1.getString(2));
                System.out.println("Business Type: " + rs1.getString(3));
                System.out.println("Business GST Number: " + rs1.getString(4));
                System.out.println("Business Address: " + rs1.getString(5));
                System.out.println("Business Annual Turnover: " + rs1.getDouble(6));
                System.out.println("Business Owner Name: " + rs1.getString(7));
                System.out.println("Business Owner Addhar Card Number: " + rs1.getString(8));
            }

        } else {
            System.out.println("\nBot: Error!! Account Number " + accountNumber + " Is Not Exits!!");
            return;
        }

    }

    void displayAccountPin(Link l1) throws Exception {
        l1.Display();
    }

    void accountNumberExits(Link l1, long accnumber, int pass) throws Exception {

        boolean b = l1.search(accnumber, pass);
        if (b) {
            System.out.println("\nBot: Account Number Is Exits..!!");
        } else {
            System.out.println("\nBot: Account Number Is Not Exits..!!");
        }
    }

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

    void TransactionMangement(Scanner sc, Connection con) throws Exception {

        String mess1 = "\nBot: Enter 1. To Transfar Money\n     Enter 2. To Withdow Money\n     Enter 3. To Deposit Money\n     ";
        String mess2 = "Enter 4. To Check BankBalnce\n     Enter 5. To Transaction History\n     Enter 6. To Exit";

        run2(mess1);
        run2(mess2);

        System.out.print("\nBot: Enter Your Choice: ");
        int cho = sc.nextInt();
        sc.nextLine();

        switch (cho) {
            case 1:

                transfarMoney(sc, con);
                break;
            case 2:
                withdowMoney(sc, con);
                break;

            case 3:

                depositMoney(sc, con);
                break;

            case 4:

                checkBankBlance(sc, con);
                break;

            case 5:

                transtionHistory(sc, con);
                break;
            case 6:
                return;
            default:
                System.out.println("\nBot: Error!! Invaild Choice!!");
                break;
        }

    }

    String ifcCode = "BANK02105";
    String ifc;
    long senderAcc, reciverAcc, accNo;
    double amount;
    int senderPin;

    void transfarMoney(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We TransFor Money";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Sender Account Number: ");
        senderAcc = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Sender Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Reciver Account Number: ");
        reciverAcc = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter IFC Code: ");
        ifc = sc.nextLine();

        System.out.print("Enter Amount To Transfar: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        boolean b = true;
        while (b) {

            if (ifc.equalsIgnoreCase(ifcCode)) {
                b = false;
            } else {
                System.out.println("Please Enter Vaild IFC Code: ");
                ifc = sc.nextLine();
            }
        }

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();

        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag1 = true;

        while (flag1) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag1 = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }
        boolean b1 = checkSenderAccountNumber(senderAcc, senderPin, amt, con);
        boolean b2 = checkReciversccountNumber(reciverAcc, con);

        if (b1) {

            if (b2) {

                String sql1 = "update savingaccount set balance = balance - ? where accountNumber = ? and pin = ?";

                PreparedStatement pst1 = con.prepareStatement(sql1);

                pst1.setDouble(1, amt);
                pst1.setLong(2, senderAcc);
                pst1.setInt(3, senderPin);

                int r1 = pst1.executeUpdate();

                String sql2 = "update savingaccount set balance = balance + ? where accountNumber = ?";

                PreparedStatement pst2 = con.prepareStatement(sql2);

                pst2.setDouble(1, amt);
                pst2.setLong(2, reciverAcc);

                int r2 = pst2.executeUpdate();

                if (r1 > 0 && r2 > 0) {
                    System.out.println("\nBot: Money Tarnsfar successfull!!");
                } else {
                    System.out.println("\nBot: Money Tarnsfar Failed!!");
                }
                String filename = senderAcc + ".txt";
                File f = new File(filename);
                f.createNewFile();

                BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));

                bw.write("----------------------------------------------------");
                bw.newLine();
                bw.write("Transfar Money:");
                bw.newLine();
                bw.write("Sender Account Number: " + senderAcc);
                bw.newLine();
                bw.write("Reciver Account Number: " + reciverAcc);
                bw.newLine();
                bw.write("Amount Transfar: " + amt);
                bw.newLine();
                bw.write("----------------------------------------------------");
                bw.newLine();

                bw.close();
            }

        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }

    }

    boolean checkSenderAccountNumber(long accountNumber, int pin, double amount, Connection con) throws Exception {

        String sql = "select * from savingaccount where accountNumber = ? and pin = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1, accountNumber);
        pst.setInt(2, pin);

        ResultSet rs = pst.executeQuery();

        double amt;
        if (rs.next()) {

            amt = rs.getDouble("balance");

            if (amt >= amount) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    boolean checkReciversccountNumber(long accountNumber, Connection con) throws Exception {

        String sql = "select * from savingaccount where accountNumber = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1, accountNumber);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    void withdowMoney(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We Withdow Money";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Account Number: ");
        accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Amount To With Drow: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag1 = true;

        while (flag1) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag1 = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        boolean b1 = checkSenderAccountNumber(accNo, senderPin, amt, con);

        if (b1) {

            String sql = "update savingaccount set balance = balance - ? where accountNumber = ? and pin = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDouble(1, amt);
            pst.setLong(2, accNo);
            pst.setInt(3, senderPin);

            int r = pst.executeUpdate();

            if (r > 0) {
                System.out.println("\nBot: With Money Successfull!!");
            } else {
                System.out.println("\nBot: Error!! Withdow Money Failed!!");
            }

            String filename = senderAcc + ".txt";
            File f = new File(filename);
            f.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));

            bw.write("----------------------------------------------------");
            bw.newLine();
            bw.write("Transfar Money:");
            bw.newLine();
            bw.write("Account Number: " + accNo);
            bw.newLine();
            bw.write("Amount Withdow: " + amt);
            bw.newLine();
            bw.write("----------------------------------------------------");
            bw.newLine();

            bw.close();
        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }
    }

    void depositMoney(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We Deposit Money";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Account Number: ");
        accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Amount To Deposit Money: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag1 = true;

        while (flag1) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag1 = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        if (checkSenderAccountNumber(accNo, senderPin, amt, con)) {

            String sql = "update savingaccount set balance = balance + ? where accountNumber = ? and pin = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDouble(1, amt);
            pst.setLong(2, senderAcc);
            pst.setInt(3, pin);

            int r = pst.executeUpdate();
            if (r > 0) {
                System.out.println("\nBot: With Money Successfull!!");
            } else {
                System.out.println("\nBot: Error!! Withdow Monet Failed!!");
                return;
            }

            String filename = senderAcc + ".txt";
            File f = new File(filename);
            f.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));

            bw.write("----------------------------------------------------");
            bw.newLine();
            bw.write("Transfar Money:");
            bw.newLine();
            bw.write("Sender Account Number: " + accNo);
            bw.newLine();
            bw.write("Deposit Amount: " + amt);
            bw.newLine();
            bw.write("----------------------------------------------------");
            bw.newLine();

            bw.close();
        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }
    }

    void checkBankBlance(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We Check Bank Blance";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Account Number: ");
        accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag1 = true;

        while (flag1) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag1 = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        if (checkAccountNumber(accNo, senderPin, con)) {

            String sql = "select balance from savingaccount where accountNumber = ? and pin = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1, accNo);
            pst.setInt(2, senderPin);

            ResultSet rs = pst.executeQuery();

            double amt;
            while (rs.next()) {
                amt = rs.getDouble("balance");
                System.out.println("\nBot: Account Balance: " + amt);
            }

        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }
    }

    void transtionHistory(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We Check Transation History";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Account Number: ");
        accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                + getRandomUppercaseLetter() + "" + getRandomNumber();
        System.out.println("\nBot: Security Captcha: " + cap);
        System.out.print("Bot: Enter Security Captcha: ");
        captcha = sc.nextLine();

        boolean flag1 = true;

        while (flag1) {

            if (captcha.equals(cap)) {
                System.out.println("Bot: Verification Suessfully!!");
                flag1 = false;
            } else {
                cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" + getRandomNumber() + ""
                        + getRandomUppercaseLetter() + "" + getRandomNumber();
                System.out.println("\nBot: New Security Captcha: " + cap);
                System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                captcha = sc.nextLine();
            }
        }

        if (checkAccountNumber(accNo, senderPin, con)) {

            String filename = accNo + ".txt";
            File f = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(f));

            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();

        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }
    }

    void personalLoan(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We Personal Loan";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Account Number: ");
        accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        if (checkAccountNumber(accNo, senderPin, con)) {

            System.out.print("Enter Amount For The Loan: ");
            double loanAmount = sc.nextDouble();
            sc.nextLine();

            while (loanAmount <= 0 || loanAmount <= 50000 || loanAmount >= 5000000) {
                System.out.print("Please Enter Vaild Amount For The Loan: ");
                loanAmount = sc.nextDouble();
                sc.nextLine();
            }

            System.out.print("Enter Your Address: ");
            String loanAddress = sc.nextLine();

            System.out.print("Enter Your Addhar Card Number: ");
            String loanAddharNumbeer = sc.nextLine().toUpperCase();

            System.out.print("Enter Your Pan Card Number: ");
            String loanpanNumber = sc.nextLine();

            System.out.print("Enter Loan Duration [In Year]: ");
            double loanDuration = sc.nextDouble();
            sc.nextLine();

            while (loanAddress == null || loanAddress.trim().equals("")) {
                System.out.print("Please Enter Vaild Address: ");
                loanAddress = sc.nextLine();
            }

            for (int i = 0; i < loanAddharNumbeer.length(); i++) {

                while (loanAddharNumbeer == null || loanAddharNumbeer.trim().equals("")
                        || loanAddharNumbeer.charAt(i) < '0'
                        || loanAddharNumbeer.charAt(i) > '9' || loanAddharNumbeer.length() < 12
                        || loanAddharNumbeer.length() > 12) {
                    System.out.print("Please Enter 12 Digits Aadhar Number: ");
                    loanAddharNumbeer = sc.nextLine();
                }

            }

            loanpanNumber = loanpanNumber.trim().toUpperCase();

            while (loanpanNumber == null || loanpanNumber.length() != 10) {
                System.out.print("Please Enter a Valid PAN Number: ");
                loanpanNumber = sc.nextLine().trim().toUpperCase();
            }

            for (int j = 0; j < 5; j++) {
                while (loanpanNumber.charAt(j) < 'A' || loanpanNumber.charAt(j) > 'Z') {
                    System.out.print("Please Enter a Valid PAN Number: ");
                    loanpanNumber = sc.nextLine().trim().toUpperCase();
                }
            }

            for (int j = 5; j < 9; j++) {
                while (loanpanNumber.charAt(j) < '0' || loanpanNumber.charAt(j) > '9') {
                    System.out.print("Please Enter a Valid PAN Number: ");
                    loanpanNumber = sc.nextLine().trim().toUpperCase();
                }
            }

            while (loanpanNumber.charAt(9) < 'A' || loanpanNumber.charAt(9) > 'Z') {
                System.out.print("Please Enter a Valid PAN Number: ");
                loanpanNumber = sc.nextLine().trim().toUpperCase();
            }

            while (loanDuration < 0 || loanDuration > 50) {
                System.out.print("Please Enter a Valid Loan Durantion: ");
                loanDuration = sc.nextDouble();
                sc.nextLine();
            }

            cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" +
                    getRandomNumber() + "" + getRandomUppercaseLetter() + "" + getRandomNumber();
            System.out.println("\nBot: Security Captcha: " + cap);
            System.out.print("Bot: Enter Security Captcha: ");
            captcha = sc.nextLine();

            boolean flag1 = true;

            while (flag1) {

                if (captcha.equals(cap)) {
                    System.out.println("Bot: Verification Suessfully!!");
                    flag1 = false;
                } else {
                    cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" +
                            getRandomNumber() + ""
                            + getRandomUppercaseLetter() + "" + getRandomNumber();
                    System.out.println("\nBot: New Security Captcha: " + cap);
                    System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                    captcha = sc.nextLine();
                }
            }

            System.out.println("\nBot: All Details Are Vaild!!");

            Double interestRate = 12.10;
            String loanmess = "Interest Rate Of Personal Loan: " + interestRate;
            p = new print(loanmess);
            p.run1();

            String sql = "insert into personalloan (accountNumber, address, addharCard, panCard, loanAmount,loanDuration ,interestRate) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1, accNo);
            pst.setString(2, loanAddress);
            pst.setString(3, loanAddharNumbeer);
            pst.setString(4, loanpanNumber);
            pst.setDouble(5, loanAmount);
            pst.setDouble(6, loanDuration);
            pst.setDouble(7, interestRate);

            int r = pst.executeUpdate();

            if (r > 0) {
                System.out.println("\nBot: Loan Approval Succesfull!!");
            } else {
                System.out.println("\nBot: Loan Approval Failed!!");
            }

            double rate = (interestRate / 12 / 100); // Monthly interest rate
            double months = loanDuration * 12; // Total number of months

            double EMI = (loanAmount * rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1);
            long totalAmount = (long) (EMI * months);

            System.out.println("Final Total Amount For Loan With Interest Rate: " + totalAmount);
        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }
    }

    void educationLoan(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We Education Loan";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Account Number: ");
        accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        if (checkAccountNumber(accNo, senderPin, con)) {

            System.out.print("Enter Amount For The Loan: ");
            double loanAmount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Course Type: ");
            String courseType = sc.nextLine();

            System.out.print("Enter Course Duration [In Year]: ");
            Double coursDur = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Your Addhar Card Number: ");
            String loanAddharNumbeer = sc.nextLine().toUpperCase();

            System.out.print("Enter Your Pan Card Number: ");
            String loanpanNumber = sc.nextLine();

            while (loanAmount <= 0 || loanAmount <= 50000 || loanAmount >= 4000000) {
                System.out.print("Please Enter Vaild Amount For The Loan: ");
                loanAmount = sc.nextDouble();
                sc.nextLine();
            }

            while (courseType == null || courseType.trim().equals("")) {
                System.out.print("Please Enter Vaild Course Type: ");
                courseType = sc.nextLine();
            }

            while (coursDur < 0 || coursDur > 50) {
                System.out.print("Please Enter a Valid Loan Durantion: ");
                coursDur = sc.nextDouble();
                sc.nextLine();
            }

            for (int i = 0; i < loanAddharNumbeer.length(); i++) {

                while (loanAddharNumbeer == null || loanAddharNumbeer.trim().equals("")
                        || loanAddharNumbeer.charAt(i) < '0'
                        || loanAddharNumbeer.charAt(i) > '9' || loanAddharNumbeer.length() < 12
                        || loanAddharNumbeer.length() > 12) {
                    System.out.print("Please Enter 12 Digits Aadhar Number: ");
                    loanAddharNumbeer = sc.nextLine();
                }

            }

            loanpanNumber = loanpanNumber.trim().toUpperCase();

            while (loanpanNumber == null || loanpanNumber.length() != 10) {
                System.out.print("Please Enter a Valid PAN Number: ");
                loanpanNumber = sc.nextLine().trim().toUpperCase();
            }

            for (int j = 0; j < 5; j++) {
                while (loanpanNumber.charAt(j) < 'A' || loanpanNumber.charAt(j) > 'Z') {
                    System.out.print("Please Enter a Valid PAN Number: ");
                    loanpanNumber = sc.nextLine().trim().toUpperCase();
                }
            }

            for (int j = 5; j < 9; j++) {
                while (loanpanNumber.charAt(j) < '0' || loanpanNumber.charAt(j) > '9') {
                    System.out.print("Please Enter a Valid PAN Number: ");
                    loanpanNumber = sc.nextLine().trim().toUpperCase();
                }
            }

            while (loanpanNumber.charAt(9) < 'A' || loanpanNumber.charAt(9) > 'Z') {
                System.out.print("Please Enter a Valid PAN Number: ");
                loanpanNumber = sc.nextLine().trim().toUpperCase();
            }

            cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" +
                    getRandomNumber() + ""
                    + getRandomUppercaseLetter() + "" + getRandomNumber();
            System.out.println("\nBot: Security Captcha: " + cap);
            System.out.print("Bot: Enter Security Captcha: ");
            captcha = sc.nextLine();

            boolean flag1 = true;
            while (flag1) {

                if (captcha.equals(cap)) {
                    System.out.println("Bot: Verification Suessfully!!");
                    flag1 = false;
                } else {
                    cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" +
                            getRandomNumber() + "" + getRandomUppercaseLetter() + "" + getRandomNumber();
                    System.out.println("\nBot: New Security Captcha: " + cap);
                    System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                    captcha = sc.nextLine();
                }
            }

            System.out.println("\nBot: All Details Are Vaild!!");

            Double interestRate = 10.24;
            String loanmess = "Interest Rate Of Personal Loan: " + interestRate;
            p = new print(loanmess);
            p.run1();

            String sql = "insert into educationloan (accountNumber, coueseType , addharCard, panCard, loanAmount,coursDuration ,interestRate) values(?, ?, ?,?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1, accNo);
            pst.setString(2, courseType);
            pst.setString(3, loanAddharNumbeer);
            pst.setString(4, loanpanNumber);
            pst.setDouble(5, loanAmount);
            pst.setDouble(6, coursDur);
            pst.setDouble(7, interestRate);

            int r = pst.executeUpdate();

            if (r > 0) {
                System.out.println("\nBot: Loan Approval Succesfull!!");
            } else {
                System.out.println("\nBot: Loan Approval Failed!!");
            }

            double rate = (interestRate / 12 / 100); // Monthly interest rate
            double months = coursDur * 12; // Total number of months

            double EMI = (loanAmount * rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1);
            long totalAmount = (long) (loanAmount + EMI * months);

            System.out.println("Final Total Amount For Loan With Interest Rate: " + totalAmount);
        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }

    }

    void businessLoan(Scanner sc, Connection con) throws Exception {

        String mess = "Bot: Okk! So We Business Loan";
        p = new print(mess);
        p.run1();

        System.out.print("\nEnter Account Number: ");
        accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Pin: ");
        senderPin = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter GST Number: ");
        String loangstNo = sc.nextLine().toUpperCase();

        System.out.print("Enter Owner Addhar Card Number: ");
        String loanAddharNumbeer = sc.nextLine().toUpperCase();

        if (checkCurrAccountNumber(accNo, senderPin, loangstNo, loanAddharNumbeer, con)) {

            System.out.print("Enter Amount For The Loan: ");
            double loanAmount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Loan Duration [In Year]: ");
            Double loanDuration = sc.nextDouble();
            sc.nextLine();

            while (loanAmount < 10000) {

                System.out.print("Please Enter Valid Loan Amount: ");
                loanAmount = sc.nextDouble();
                sc.nextLine();
            }

            while (loanDuration < 0 || loanDuration > 50) {

                System.out.print("Please Enter Valid Loan Amount: ");
                loanAmount = sc.nextDouble();
                sc.nextLine();
            }

            cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" +
                    getRandomNumber() + ""
                    + getRandomUppercaseLetter() + "" + getRandomNumber();
            System.out.println("\nBot: Security Captcha: " + cap);
            System.out.print("Bot: Enter Security Captcha: ");
            captcha = sc.nextLine();

            boolean flag1 = true;
            while (flag1) {

                if (captcha.equals(cap)) {
                    System.out.println("Bot: Verification Suessfully!!");
                    flag1 = false;
                } else {
                    cap = getRandomNumber() + "" + getRandomLowercaseLetter() + "" +
                            getRandomNumber() + "" + getRandomUppercaseLetter() + "" + getRandomNumber();
                    System.out.println("\nBot: New Security Captcha: " + cap);
                    System.out.print("Bot: Error! Please Enter Vaild Security Captcha: ");
                    captcha = sc.nextLine();
                }
            }

            System.out.println("\nBot: All Details Are Vaild!!");

            Double interestRate = 7.85;
            String loanmess = "Interest Rate Of Personal Loan: " + interestRate;
            p = new print(loanmess);
            p.run1();

            String sql = "insert into businessloan (accountNumber, gstNumber , addharCard, loanAmount,loanDuration ,interestRate) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1, accNo);
            pst.setString(2, loangstNo);
            pst.setString(3, loanAddharNumbeer);
            pst.setDouble(4, loanAmount);
            pst.setDouble(5, loanDuration);
            pst.setDouble(6, interestRate);

            int r = pst.executeUpdate();

            if (r > 0) {
                System.out.println("\nBot: Loan Approval Succesfull!!");
            } else {
                System.out.println("\nBot: Loan Approval Failed!!");
            }

            double rate = (interestRate / 12 / 100); // Monthly interest rate
            double months = loanDuration * 12; // Total number of months

            double EMI = (loanAmount * rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1);
            long totalAmount = (long) (EMI * months);

            System.out.println("Final Total Amount For Loan With Interest Rate: " + totalAmount);
        } else {
            System.out.println("\nBot: Error! Account Number Is Not Found!!");
        }

    }

}