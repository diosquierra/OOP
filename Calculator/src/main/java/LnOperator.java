import java.util.Deque;

public class LnOperator implements CalcOperator {

    @Override
    public String getOperatorRepresentation() {
        return "ln";
    }

    @Override
    public void Apply(Deque<String> numDeque) {
        numDeque.push(String.valueOf(Math.log(Double.parseDouble(numDeque.pop()))));
    }

    @Override
    public int getArity() {
        return 1;
    }
}
