import java.util.Deque;

public class PowOperator implements CalcOperator {

    @Override
    public String getOperatorRepresentation() {
        return "pow";
    }

    @Override
    public void Apply(Deque<String> numDeque) {
        double base = Double.parseDouble(numDeque.pop());
        double power = Double.parseDouble(numDeque.pop());
        numDeque.push(String.valueOf(Math.pow(base, power)));
    }

    @Override
    public int getArity() {
        return 2;
    }
}
