package com;

import java.util.Scanner;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];

        //multiple catch blocks
        try {
//          arr[6] = 10 / 0;
//            arr[6] = 10;
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //catch blocks in single catch
        try {
//          arr[6] = 10 / 0;
            arr[6] = 10;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
}
