import java.util.Stack;

/**
 * Interface which represents all orerators
 */
public interface CalcOperator {
    String getOperatorRepresentation();
    void Apply(Stack<String> numStack);
    int getArity();
}
