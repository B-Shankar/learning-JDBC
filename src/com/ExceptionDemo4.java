package com;

import java.util.Scanner;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();

        if(age < 18){
//            System.out.println("Sorry you are not eligible!");
            throw new RuntimeException("Sorry you can't vote!");
        } else {
            System.out.println("You are eligible to vote!");
        }
    }
}
