package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try (Scanner sc = new Scanner(System.in)) {
            Calculate calc = new Calculate();
            boolean status = true;
            String input;

            while (status) {
                if (calc.inputData(input = sc.nextLine())) {
                    calc.showAnswer();
                } else {
                    status = calc.commands(input);
                }
            }
        }
    }
}
