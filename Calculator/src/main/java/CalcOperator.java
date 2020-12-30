import java.util.Deque;

/**
 * Interface which represents all orerators
 */
public interface CalcOperator {
    String getOperatorRepresentation();
    void Apply(Deque<String> numDeque);
    int getArity();
}
