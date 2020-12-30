import java.util.Deque;

public class SinOperator implements CalcOperator {

    @Override
    public String getOperatorRepresentation() {
        return "sin";
    }

    @Override
    public void Apply(Deque<String> numDeque) {
        numDeque.push(String.valueOf(Math.sin(Double.parseDouble(numDeque.pop()))));
    }

    @Override
    public int getArity() {
        return 1;
    }
}