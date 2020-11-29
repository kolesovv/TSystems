package com.tsystems.javaschool.tasks.calculator;

import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String infix){
        if (!CorrectInputCalculator.correctInputCalculator(infix)) return null;
        String postfix = "";
        Stack<Character>characterStack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);
            if (!(priorityOfOperator(currentChar) > 0)){
                postfix += currentChar;
            }
            else if (currentChar == ')'){
                postfix += " ";
                char charPop = characterStack.pop();
                while (charPop != '('){
                    postfix += charPop;
                    charPop = characterStack.pop();
                }
            }
            else {
                postfix += " ";
                while (!characterStack.isEmpty()
                        && characterStack.peek() != '('
                        && priorityOfOperator(characterStack.peek()) >= priorityOfOperator(currentChar)){
                    postfix += characterStack.pop() + " ";
                }
                characterStack.push(currentChar);
            }
        }
        while (!characterStack.isEmpty()){
            postfix += " ";
            postfix += characterStack.pop();
        }
        return postfix.replace(",",".");
    }

    private static int priorityOfOperator(char operator){
        if (operator == '(' || operator == ')') return 3;
        if (operator == '*' || operator == '/') return 2;
        if (operator == '+' || operator == '-') return 1;
        return 0;
    }
}
