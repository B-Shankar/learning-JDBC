package com;

public class Rough {
    public static void main(String[] args) {
        System.out.println(utopianTree(5));
    }

    public static int utopianTree (int n) {
        int height = 1;
        //            if(i % 2 == 0) {
        //                height += 1;
        //            } else {
        //                height *= 2;
        //            }
        for (int i = 1; i <= n; i++) height = (i % 2 == 0) ? height + 1 : height * 2;
        return height;
    }
}
