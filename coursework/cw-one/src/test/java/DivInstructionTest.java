import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivInstructionTest {

    String label = "label";
    String opcode = "div";
    String symbol = " / ";
    int result = 0;
    int op1 = 1;
    int op2 = 2;
    int val1 = 1;
    int val2 = 2;
    int sum  = val1 / val2;
    Instruction instruction;

    @Before
    public void buildInstruction() {
        instruction = new DivInstruction(label, result, op1, op2);
    }

    @Test
    public void test_execute() {
        new MathsInstructionTest().test_execute(instruction, sum);
    }

    @Test
    public void test_toString() {
        new MathsInstructionTest().test_toString(instruction, label, opcode, symbol);
    }
}