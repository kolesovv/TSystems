package com.tsystems.javaschool.tasks.calculator;

public class CorrectInputCalculator {
    public static boolean correctInputCalculator(String input){
        return isInputNull(input);
    }

    private static boolean isInputNull(String input) {
        if(input == null || input.equals("")){
            return false;
        }
        else {
            return checkBrackets(input);
        }
    }

    private static boolean checkBrackets(String input) {
        int openBrackets = 0;
        int closedBrackets = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c){
                case '(':
                    openBrackets++;
                    break;
                case ')':
                    closedBrackets++;
                    break;
            }
        }
        if (openBrackets != closedBrackets){
            return false;
        }
        else {
            return checkCharacterOrder(input);
        }
    }

    private static boolean checkCharacterOrder(String input) {
        if (input.contains(",")) return false;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && !Character.isDigit(input.charAt(i)) &&
                    (input.charAt(i) != '(' || input.charAt(i) != ')')) {
                return false;
            }
        }
        return true;
    }
}
