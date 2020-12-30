import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitClassCalculator {
    @Test
    void requestedTest(){
        MyCalculator calc = new MyCalculator();
        calc.registerOperator(new SinOperator());
        calc.registerOperator(new CosOperator());
        calc.registerOperator(new Plus());
        calc.registerOperator(new LnOperator());
        calc.registerOperator(new Minus());
        calc.registerOperator(new Division());
        calc.registerOperator(new Multiplication());
        calc.registerOperator(new PowOperator());
        String res = calc.calculate("* 3 + 2 ln / pow + cos sin - + 1 2 3 1 10 1024");
        assertEquals(Double.valueOf(6), Double.valueOf(res));
    }
}
