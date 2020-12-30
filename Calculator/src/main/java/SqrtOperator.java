import java.util.Deque;

public class SqrtOperator implements CalcOperator {

    @Override
    public String getOperatorRepresentation() {
        return "sqrt";
    }

    @Override
    public void Apply(Deque<String> numDeque) {
        numDeque.push(String.valueOf(Math.sqrt(Double.parseDouble(numDeque.pop()))));
    }

    @Override
    public int getArity() {
        return 1;
    }
}
