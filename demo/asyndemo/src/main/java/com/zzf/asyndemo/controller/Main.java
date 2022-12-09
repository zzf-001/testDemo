package com.zzf.asyndemo.controller;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = Double.parseDouble(scan.nextLine());
        double yushu = num - (int) num;
        if (yushu >= 0.5) {
            System.out.println(Math.ceil(num));
        } else {
            System.out.println(Math.floor(num));

        }

    }
}