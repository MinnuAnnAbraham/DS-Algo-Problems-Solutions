import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostfixEvaluator {

    private final Map<Character, Operation> operations;

    public PostfixEvaluator(Map<Character, Operation> operations) {
        this.operations = operations;
    }

    public static int evaluatePostfix(String expression, Map<Character, Operation> operations) throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else if (operations.containsKey(c)) {
                Operation operation = operations.get(c);
                int operandCount = operation.getOperandCount();
                if (stack.size() < operandCount) {
                    throw new Exception("Invalid postfix expression: missing operand(s)");
                }
                int[] operands = new int[operandCount];
                for (int i = operandCount - 1; i >= 0; i--) {
                    operands[i] = stack.pop();
                }
                int result = operation.evaluate(operands);
                stack.push(result);
            } else {
                throw new Exception("Invalid operator: " + c);
            }
        }
        if (stack.size() != 1) {
            throw new Exception("Invalid postfix expression: extra characters");
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // Define operations using interface
        Map<Character, Operation> operations = new HashMap<>();
        operations.put('+', new BinaryOperation((a, b) -> a + b));
        operations.put('-', new BinaryOperation((a, b) -> a - b));
        operations.put('*', new BinaryOperation((a, b) -> a * b));
        operations.put('/', new BinaryOperation((a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }));
        operations.put('^', new BinaryOperation((a, b) -> (int) Math.pow(a, b))); // Power operation
        operations.put('-', new UnaryOperation(x -> -x)); // Unary minus

        try {
            String expression = "2 - 45 / 5 3 - 5 ^ 4 * +";
            int result = evaluatePostfix(expression, operations);
            System.out.println("Result of postfix expression: " + expression + " = " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @FunctionalInterface
    public interface Operation {
        int evaluate(int[] operands);

        default int getOperandCount() {
            return 2; // Default for binary operations
        }
    }

    public static class BinaryOperation implements Operation {

        private final BiFunction<Integer, Integer, Integer> operation;

        public BinaryOperation(BiFunction<Integer, Integer, Integer> operation) {
            this.operation = operation;
        }

        @Override
        public int evaluate(int[] operands) {
            return operation.apply(operands[0], operands[1]);
        }
    }

    public static class UnaryOperation implements Operation {

        private final Function<Integer, Integer> operation;

        public UnaryOperation(Function<Integer, Integer> operation) {
            this.operation = operation;
        }

        @Override
        public int evaluate(int[] operands) {
            return operation.apply(operands[0]);
        }

        @Override
        public int getOperandCount() {
            return 1; // Unary operation requires 1 operand
        }
    }
}
