package com.hami.leetcode;

import java.util.Stack;

//A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
//
//'t' that evaluates to true.
//'f' that evaluates to false.
//'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
//'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//Given a string expression that represents a boolean expression, return the evaluation of that expression.
//
//It is guaranteed that the given expression is valid and follows the given rules.
//
// 
//
//Example 1:
//
//Input: expression = "&(|(f))"
//Output: false
//Explanation: 
//First, evaluate |(f) --> f. The expression is now "&(f)".
//Then, evaluate &(f) --> f. The expression is now "f".
//Finally, return false.
//Example 2:
//
//Input: expression = "|(f,f,f,t)"
//Output: true
//Explanation: The evaluation of (false OR false OR false OR true) is true.
//Example 3:
//
//Input: expression = "!(&(f,t))"
//Output: true
//Explanation: 
//First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
//Then, evaluate !(f) --> NOT false --> true. We return true.

public class ParseBooleanExpression {
	
	private boolean parseBooleanExpression(String expression) {
		Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                // We're at the end of a sub-expression, so process it
                Stack<Character> operands = new Stack<>();
                
                while (stack.peek() != '(') {
                    operands.push(stack.pop());
                }
                stack.pop(); // remove '('
                char operator = stack.pop(); // Get the operator before '('

                // Evaluate the current sub-expression based on the operator
                boolean result;
                if (operator == '&') {
                    result = true; // AND needs all true to remain true
                    while (!operands.isEmpty()) {
                        if (operands.pop() == 'f') {
                            result = false; // If any false, result is false
                        }
                    }
                } else if (operator == '|') {
                    result = false; // OR needs any true to become true
                    while (!operands.isEmpty()) {
                        if (operands.pop() == 't') {
                            result = true; // If any true, result is true
                        }
                    }
                } else { // operator == '!'
                    result = operands.pop() == 'f'; // NOT flips the value
                }

                // Push the result back onto the stack
                stack.push(result ? 't' : 'f');
            } else if (ch != ',' && ch != '(') {
                // Push everything except commas and opening parenthesis
                stack.push(ch);
            } else if (ch == '(' ) {
                // Continue processing, skip parentheses and commas
                stack.push(ch); // Push the opening parenthesis
            }
        }

        // The last element in the stack will be the result
        return stack.pop() == 't';
	}
}
