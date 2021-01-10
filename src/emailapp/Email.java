package emailapp;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailboxCapacity = 500; // Assigning the amount of memory that can receive mail (in megabytes)
    private String alternateEmail;
    private int defaultPasswordLength = 10; // Assigning the number of characters that the password can accept
    private String email;
    private String CompanySuffix = "company.com";

    // Create password mail
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.department = setDepartment();

        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + this.CompanySuffix;

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your new password is:" + " " + this.password);
    }

    // Setting the value of the department that the user enters
    private String setDepartment() {
        System.out.println("New worker:" + " " + firstname + "\n" + "Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n4 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    // Generating a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%"; // Set the values that the password can take
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set methods
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password) {
        this.password = password;
    }

    // Get methods
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }

    // Returning basic mail information
    public String showInfo() {
        return "DISPLAY NAME:" + " " + firstname + " " + lastname +
                "\nCOMPANY EMAIL:" + " " + email +
                "\nMAILBOX CAPACITY:" + " " + mailboxCapacity + "mb";
    }

}
