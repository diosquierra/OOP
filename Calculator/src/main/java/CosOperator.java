import java.util.Deque;

public class CosOperator implements CalcOperator {

    @Override
    public String getOperatorRepresentation() {
        return "cos";
    }

    @Override
    public void Apply(Deque<String> numDeque) {
        numDeque.push(String.valueOf(Math.cos(Double.parseDouble(numDeque.pop()))));
    }

    @Override
    public int getArity() {
        return 1;
    }
}
