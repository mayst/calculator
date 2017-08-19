package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculate {
    private String history;
    private double[] vars = new double[2];
    private double operation;

    Calculate() {
        System.out.println("Enter equation please:");
        history = "";
    }

    boolean Input_data(String operation) {
        Pattern p = Pattern.compile("^-?[0-9]+.?[0-9]*\\s?(\\+|-|\\*|/)\\s?-?[0-9]+.?[0-9]*$");
        Matcher m = p.matcher(operation);

        if(m.matches()) {
            history += operation;
        } else {
            return false;
        }

//        -?[0-9]+.?[0-9]*
        String[] str = operation.split("(\\+|-|\\*|/)");

        for(String s: str) {
            System.out.println(s);
        }

        return true;
    }

    boolean Commands(String command) {
        switch(command) {
            case "-quite":
                return false;
            default:
                System.out.println("Equation is incorrect!");

                return false;
        }
    }
}
