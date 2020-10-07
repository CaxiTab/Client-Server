package sample;

public enum Operation {
    ADD{
        @Override
        public double operate(double firstOperand, double secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MULTIPLY {
        @Override
        public double operate(double firstOperand, double secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVIDE {
        @Override
        public double operate(double firstOperand, double secondOperand) {
            return firstOperand / secondOperand;
        }
    },
    SUBTRACT {
        @Override
        public double operate(double firstOperand, double secondOperand) {
            return firstOperand - secondOperand;
        }
    };

    public abstract double operate(double firstOperand, double secondOperand);
}
