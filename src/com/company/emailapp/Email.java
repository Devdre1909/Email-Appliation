package com.company.emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String email;

    public String getFullName() {
        return firstName+" "+lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }


    // Constructor
    Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: "+ firstName + " " + lastName);

        // Call set department method to get user department
        String department = setDepartment();
        System.out.println("Department is "+ department);

        // Call set password
        int defaultPasswordLength = 10;
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password is: "+this.password);

        // set email
        String company = "xcoder";
        if (department != ""){
            this.email = this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+ department.toLowerCase()+"."+ company.toLowerCase()+".com";
        } else {
            this.email = this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+ department.toLowerCase()+ company.toLowerCase()+".com";
        }

        System.out.println("Email: "+this.email);
    }

    /**
     * @ Request department from user and returns it
     */
    private String setDepartment(){
        System.out.println("DEPARTMENT CODES\n1. Sales\n2. Development \n3. Accounting\n0. None \nEnter department code: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1:
                return "Sales";
            case 2:
                return "Development";
            case 3:
                return "Accounting";
            case 0:
                return "";
            default:
                System.out.println("Invalid selection! Defaults to none");
                return "";
        }
    }

    /**
     * Returns a generated random password
     * @param length password length
     * @return the generated password
     */
    private String randomPassword(int length){
         String alphas = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
         String numbers = "1234567890";
         String symbols = "{}[]!@$-_";
         String passwordSet = alphas+numbers+symbols;
         StringBuilder generatedPassword = new StringBuilder();
         if (length < 8) {
             System.out.println("Minimum length is 8!\nDefaults to 8");
             length = 8;
         }
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            generatedPassword.append(passwordSet.charAt(rand));
        }
        return generatedPassword.toString();
    }

    /**
     * Set mailbox capacity
     * @param capacity specified mailbox capacity
     */
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    /**
     * Set alternate emails
     * @param email email for alternate email
     */
    public void setAlternateEmail(String email){
        this.alternateEmail = email;
    }

    /**
     * Change password
     * @param password new password
     */
    public void  changePassword(String password){
        this.password = password;
    }

    public String showInfo(){
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter your password to show you info; ");
        String password = scanner.next();
        if (!password.equals(this.password)){
            return "Invalid password";
        } else {
            return "Account Name: "+firstName+ " " + lastName+"\nPassword: "+this.password+"\nEmail: "+email+"\n Mailbox size: "+mailboxCapacity;
        }

    }

}
