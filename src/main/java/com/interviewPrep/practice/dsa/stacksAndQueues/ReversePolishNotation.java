package com.interviewPrep.practice.dsa.stacksAndQueues;

public class ReversePolishNotation {

    public int calculate(String[] input){
        // you can add input validations.
        BasicStack stack = new BasicStack();

        for (int i = 0; i < input.length; i++) {
            if (!input[i].matches("[+\\-*/]")){
                stack.push(Integer.parseInt(input[i]));
            } else {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                int result = switch (input[i]){
                    case "+" -> leftOperand + rightOperand;
                    case "-" -> leftOperand - rightOperand;
                    case "*" -> leftOperand * rightOperand;
                    case "/" -> leftOperand / rightOperand;
                    default -> throw new IllegalStateException("Invalid operator" + input[i]);
                };
                stack.push(result);
            }
        }
        return stack.pop();
    }

}
