package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        Calculate calc = new Calculate();
        boolean status = true;
        String input;

        while(status) {
            if(calc.Input_data(input = sc.nextLine())) {
                System.out.println("Here will be answer");
            } else {
                status = calc.Commands(input);
            }
        }
    }
}
