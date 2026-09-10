package com.interviewPrep.practice.dsa.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {

    public boolean isValid(String input){

        Map<Character, Character> parenthesisMatch = new HashMap<>();
        parenthesisMatch.put('(',')');
        parenthesisMatch.put('{','}');
        parenthesisMatch.put('[',']');

        // first save the opening ones in a stack
        BasicStack openingParenthesisStack = new BasicStack();
        for (int i = 0; i < input.length(); i++) {
            if (parenthesisMatch.containsKey(input.charAt(i))){
                openingParenthesisStack.push(input.charAt(i));
            } else {
                if (openingParenthesisStack.isEmpty()) return false;
                if (parenthesisMatch.get((char)openingParenthesisStack.peek()) == input.charAt(i)) openingParenthesisStack.pop();
                else return false;
            }
        }
        // you just need to check the stack since the closing won't be processed if opening is null.
        if (openingParenthesisStack.isEmpty()) return true;
        return false;
    }
}
