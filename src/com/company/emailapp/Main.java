package com.company.emailapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Email user1 = new Email("Temitope","Adegoke");
	    System.out.println(user1.getFullName());
        System.out.println(user1.getEmail());
        user1.changePassword("Temiloluwa");
        user1.setAlternateEmail("adegoketemitope1909@gmail.com");
        System.out.println(user1.showInfo());

    }


}
