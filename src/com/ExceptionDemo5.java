package com;

public class ExceptionDemo5 {
    public static void divisionDemo(int dividend, int divisor) throws ArithmeticException{
        System.out.println("Answer is " + dividend/divisor);
    }
    public static void main(String[] args) {
        divisionDemo(10, 0);
    }
}
