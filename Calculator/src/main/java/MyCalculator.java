import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
public class MyCalculator {
    private final HashMap<String, CalcOperator> operators = new HashMap<>();

    /**
     * calculate is public method which is calculating the string
     *
     * @param string to be calculated
     * @return string representation of result
     */
    public String calculate(String string) {
        String[] arr = string.split(" ");
        Deque<String> numDeque = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            String elem = arr[i];
            if (isNumber(elem)) {
                numDeque.push(elem);
            } else if (operators.containsKey(elem)) {
                computeOperation(elem, numDeque);
            } else {
                throw new IllegalArgumentException("This is illegal value: " + elem);
            }
        }
        if(numDeque.size() != 1){
            throw new IllegalArgumentException("String is not computable");
        }
        return numDeque.pop();
    }

    /**
     * isNumber is private boolean method which is checking is arg a number.
     * @param arg - argument
     * @return true if yes else false
     */
    private boolean isNumber(String arg) {
        try {
            double d = Double.parseDouble(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * computeOperation is public method which is calculating an operation.
     * @param operation
     * @param numDeque - num
     */
    private void computeOperation(String operation, Deque<String> numDeque) {
        if (numDeque.size() < operators.get(operation).getArity()) {
            throw new IllegalArgumentException("Cannot parse this expression");
        }
        operators.get(operation).Apply(numDeque);
    }

    /**
     * registerOperator is public method which is registering new command for our calculator.
     *
     * @param command operator we need to add to calculator
     */
    public void registerOperator(CalcOperator command) {
        if (command == null) {
            throw new IllegalArgumentException("command is null");
        }
        operators.put(command.getOperatorRepresentation(), command);
    }


    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Pass the only one string with the expression");
        }

        MyCalculator calc = new MyCalculator();
        calc.registerOperator(new SinOperator());
        calc.registerOperator(new CosOperator());
        calc.registerOperator(new Plus());
        calc.registerOperator(new LnOperator());
        calc.registerOperator(new Minus());
        calc.registerOperator(new Division());
        calc.registerOperator(new Multiplication());
        calc.registerOperator(new PowOperator());
        System.out.println(calc.calculate(args[0]));
    }
}
