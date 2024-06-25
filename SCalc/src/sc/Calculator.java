package sc;

public class Calculator {
    private double currentResult;
    private String lastOperation;
    private boolean isFirstCalculation;

    public Calculator() {
        reset();
    }

    public void reset() {
        currentResult = 0;
        lastOperation = "=";
        isFirstCalculation = true;
    }

    public double getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(double currentResult) {
        this.currentResult = currentResult;
    }

    public void setLastOperation(String operation) {
        this.lastOperation = operation;
    }

    public boolean isFirstCalculation() {
        return isFirstCalculation;
    }

    public void setFirstCalculation(boolean firstCalculation) {
        isFirstCalculation = firstCalculation;
    }

    public double calculate(double number) {
        switch (lastOperation) {
            case "+":
                currentResult += number;
                break;
            case "-":
                currentResult -= number;
                break;
            case "*":
                currentResult *= number;
                break;
            case "/":
                if (number != 0) {
                    currentResult /= number;
                } else {
                    throw new ArithmeticException("Error: Division by zero");
                }
                break;
            case "sqrt":
                currentResult = Math.sqrt(currentResult);
                break;
            case "log":
                currentResult = Math.log(currentResult);
                break;
            case "sin":
                currentResult = Math.sin(Math.toRadians(currentResult));
                break;
            case "cos":
                currentResult = Math.cos(Math.toRadians(currentResult));
                break;
            case "tan":
                currentResult = Math.tan(Math.toRadians(currentResult));
                break;
            case "cbrt":
                currentResult = Math.cbrt(currentResult);
                break;
            case "square":
                currentResult = Math.pow(currentResult, 2);
                break;
            case "cube":
                currentResult = Math.pow(currentResult, 3);
                break;
            case "=":
                currentResult = number;
                break;
        }
        return currentResult;
    }
}
