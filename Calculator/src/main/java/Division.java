import java.util.Deque;

public class Division implements CalcOperator {
    @Override
    public String getOperatorRepresentation() {
        return "/";
    }

    @Override
    public void Apply(Deque<String> numDeque) {
        double l = Double.parseDouble(numDeque.pop());
        double r = Double.parseDouble(numDeque.pop());
        numDeque.push(String.valueOf(l / r));
    }

    @Override
    public int getArity() {
        return 2;
    }
}
