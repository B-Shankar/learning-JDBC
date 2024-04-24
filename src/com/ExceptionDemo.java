package com;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dividend = input.nextInt();
        int divisor = input.nextInt();
        int[] arr = new int[5];
        arr[6] = 10 / 0;
        try {
            int result = dividend / divisor;
            System.out.println("Answer is " + result);
        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
            System.out.println("divisor can't be zero!!!");
        }

    }
}
