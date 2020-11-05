package com.michau.selenium;


import java.util.Scanner;

public class FirstRanking {
    public static void main(String[] args) {


    }

    public void ad1() {
        final Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println((N % 2 == 1 || (N >= 6 && N <= 20)) ? "Weird" : "Not Weird");
        scanner.close();
    }

    public void ad2() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}



