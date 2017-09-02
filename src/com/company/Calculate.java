package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculate {
    private String history;
    private double[] vars = new double[2];
    private String operation;
    private double answer;
    private final static Pattern START_EQUATION_PATTERN = Pattern.compile("^-?[0-9]+.?[0-9]*\\s?(\\+|-|\\*|/)\\s?-?[0-9]+.?[0-9]*$");
    private final static Pattern EQUATION_PATTERN = Pattern.compile("^\\s?(\\+|-|\\*|/)\\s?-?[0-9]+.?[0-9]*$");

    Calculate() {
        System.out.println("Enter equation please:");
        history = "";
    }

    boolean inputData(String operation) {
       if(history.equals("")) {
           Matcher m = START_EQUATION_PATTERN.matcher(operation);

           if(m.matches()) {
               history += operation + " ";
           } else {
               return false;
           }

           String[] str = operation.split("(\\+|-|\\*|/)");
           int i = 0;

           for(String s: str) {
               vars[i] = Double.parseDouble(s);
               operation = operation.replace(s, "");
               i++;
           }
       } else {
           Matcher m = EQUATION_PATTERN.matcher(operation);

           if(m.matches()) {
               history += operation + " ";
           } else {
               return false;
           }

           String str = operation.replaceAll("( |\\+|-|\\*|/)", "");
           vars[0] = answer;
           vars[1] = Double.parseDouble(str);
           operation = operation.replace(str, "");
       }

        this.operation = operation;

        return true;
    }

    void showAnswer() {
        switch(this.operation) {
            case "+":
                answer = vars[0] + vars[1];
                break;
            case "-":
                answer = vars[0] - vars[1];
                break;
            case "*":
                answer = vars[0] * vars[1];
                break;
            case "/":
                answer = vars[0] / vars[1];
                break;
        }

        System.out.println(history);
        System.out.println(answer);
    }

    boolean commands(String command) {
        switch(command) {
            /*case "-back":
                StringBuffer sb = new StringBuffer(history.trim());
                sb.delete(sb.lastIndexOf(" "), sb.length());
                history = sb.toString();

                return true;*/
            case "-clear":
                history = "";
                operation = "";

                return true;
            case "-quite":
                return false;
            default:
                System.out.println("Equation is incorrect!");

                return false;
        }
    }
}
