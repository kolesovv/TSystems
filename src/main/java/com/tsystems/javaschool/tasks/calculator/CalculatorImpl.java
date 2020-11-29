package com.tsystems.javaschool.tasks.calculator;

import java.text.DecimalFormat;
import java.util.Stack;

public class CalculatorImpl implements Calculator {
    @Override
    public String evaluate(String statement) {
        String postfix = InfixToPostfix.infixToPostfix(statement);
        if(postfix == null) return postfix;
        String[] data = postfix.trim().split(" ");
        Stack<Double>doubleStack = new Stack<>();
        double value;
        for (int i = 0; i < data.length; i++) {
            if(data[i].isEmpty()) {
             continue;
            }
            else if (!data[i].equals("+") &&
                !data[i].equals("-") &&
                !data[i].equals("*") &&
                !data[i].equals("/")) {
                value = Double.parseDouble(data[i]);
                doubleStack.push(value);
            }
            else {
                String resultCalculate = calculate(doubleStack.pop(), doubleStack.pop(), data[i]);
                if (resultCalculate == null) return resultCalculate;
                doubleStack.push(Double.parseDouble(resultCalculate));
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        return decimalFormat.format(doubleStack.pop()).replace(",",".");
    }

    private String calculate(Double number1, Double number2, String operator){
        switch (operator){
            case "+":
                return String.valueOf(number1 + number2);
            case "-":
                return String.valueOf(number2 - number1);
            case "*":
                return String.valueOf(number1 * number2);
            case "/":
                if (number1 == 0) {
                    return null;
                }
                return String.valueOf(number2 / number1);
            default: return null;
        }
    }
}