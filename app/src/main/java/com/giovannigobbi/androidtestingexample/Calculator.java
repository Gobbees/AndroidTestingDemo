package com.giovannigobbi.androidtestingexample;

public class Calculator {

    public double calculate(String text) throws InvalidOperationException {
        Operation operation = fromString(text);
        double result;
        switch(operation.operator) {
            case PLUS:
                result = operation.firstNum + operation.secondNum;
                break;
            case MINUS:
                result = operation.firstNum - operation.secondNum;
                break;
            case TIMES:
                result = operation.firstNum * operation.secondNum;
                break;
            case DIVIDED:
                result = operation.firstNum / operation.secondNum;
                break;
            default:
                throw new InvalidOperationException();
        }
        return result;
    }

    private Operation fromString(String string) throws InvalidOperationException{
        StringBuilder firstNum = new StringBuilder();
        StringBuilder secondNum = new StringBuilder();
        Operator operator = null;
        boolean isFirstNum = true;

        for(char c: string.toCharArray()) {
            if(c == '+') {
                if(!isFirstNum) {
                    throw new InvalidOperationException();
                }
                operator = Operator.PLUS;
                isFirstNum = false;
            } else if(c == '-') {
                if(!isFirstNum) {
                    throw new InvalidOperationException();
                }
                operator = Operator.MINUS;
                isFirstNum = false;
            } else if(c == '*') {
                if(!isFirstNum) {
                    throw new InvalidOperationException();
                }
                operator = Operator.TIMES;
                isFirstNum = false;
            } else if(c == '/') {
                if(!isFirstNum) {
                    throw new InvalidOperationException();
                }
                operator = Operator.DIVIDED;
                isFirstNum = false;
            } else {
                if(isFirstNum) {
                    firstNum.append(c);
                } else {
                    secondNum.append(c);
                }
            }
        }
        if(operator == null) {
            throw new InvalidOperationException();
        }

        return new Operation(Double.parseDouble(firstNum.toString()), Double.parseDouble(secondNum.toString()), operator);
    }

    private class Operation {
        double firstNum;
        double secondNum;
        Operator operator;

        public Operation(double firstNum, double secondNum, Operator operator) {
            this.firstNum = firstNum;
            this.secondNum = secondNum;
            this.operator = operator;
        }
    }

    private enum Operator {
        PLUS,
        MINUS,
        TIMES,
        DIVIDED
    }
}
