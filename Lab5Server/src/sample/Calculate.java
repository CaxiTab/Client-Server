package sample;

public class Calculate {
    private double firstOperand;
    private double secondOperand;
    private double result;
    String operation;

    public Calculate(double firstOperand, double secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    public double operate() {
        switch (operation) {
            case "+" -> result = Operation.ADD.operate(firstOperand, secondOperand);
            case "-" -> result = Operation.SUBTRACT.operate(firstOperand, secondOperand);
            case "*" -> result = Operation.MULTIPLY.operate(firstOperand, secondOperand);
            case "/" -> result = Operation.DIVIDE.operate(firstOperand, secondOperand);
        }
        return result;
    }

}
