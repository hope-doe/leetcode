package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculator {

    Stack<Object> expression = new Stack<>();

    // -43 + 23 - ( - 14 + 5 - 23 )

    public int calculate(String s) {
        Queue<Integer> currentOperand = new ArrayDeque<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case ' ':
                    break;
                case '(':
                    if (!currentOperand.isEmpty()) {
                        expression.push(computeOperand(currentOperand));
                    }
                    expression.push(computeExpression());
                    break;
                case '+':
                case '-':
                    if (!currentOperand.isEmpty()) {
                        expression.push(computeOperand(currentOperand));
                    }
                    expression.push(s.charAt(i));
                    break;
                case ')':
                    expression.push(s.charAt(i));
                    break;
                default:
                    if (Character.isDigit(s.charAt(i))) {
                        currentOperand.add(Character.digit(s.charAt(i), 10));
                    } else {
                        throw new IllegalStateException("Unexpected character >> " + s.charAt(i));
                    }
                    break;
            }
        }

        if (!currentOperand.isEmpty()) {
            expression.push(computeOperand(currentOperand));
        }

        return computeExpression();
    }

    private int computeOperand(Queue<Integer> currentOperand) {
        int result = 0;
        int power = 1;

        while (!currentOperand.isEmpty()) {
            result = result + currentOperand.poll() * power;
            power = power * 10;
        }

        return result;

    }

    private int computeExpression() {
        if (expression.isEmpty()) {
            throw new IllegalStateException("There is nothing to compute!");
        } else if (Objects.equals(expression.peek(), '-')) {
            expression.push(0);
            return computeExpression();
        } else if (expression.size() == 1) {
            return (int) expression.pop();
        } else {
            return runOperation((int) expression.pop(), expression);
        }
    }

    private int runOperation(int operand1, Stack<Object> expression) {
        if (expression.isEmpty()) {
            return operand1;
        } else {
            switch ((char) expression.pop()) {
                case ')':
                    return operand1;
                case '-':
                    return runOperation(operand1 - ((int) expression.pop()), expression);
                case '+':
                    return runOperation(operand1 + ((int) expression.pop()), expression);
                default:
                    throw new IllegalStateException("Unknown operator");
            }
        }
    }
}

