package com;

public class ExceptionDemo6 {
    public static void main(String[] args) {
//        try {
//            int x = 10 / 0;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }

        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
