package com.zzf.asyndemo.controller;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            System.out.println(cal(num));
        }
    }

    public static int cal(int num) {
        return num / 2;
    }
}
