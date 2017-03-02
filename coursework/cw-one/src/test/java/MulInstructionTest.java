import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MulInstructionTest {

    String label = "label";
    String opcode = "mul";
    int result = 0;
    int op1 = 1;
    int op2 = 2;
    int val1 = 1;
    int val2 = 2;
    int sum  = val1 * val2;
    Instruction instruction;

    @Before
    public void buildInstruction() {
        instruction = new MulInstruction(label, result, op1, op2);
    }

    @Test
    public void test_execute() {
        new MathsInstructionTest().test_execute(instruction, sum);
    }

    @Test
    public void test_toString() {
        assertEquals(label + ": " + opcode + " " + op1 + " * " + op2 + " to " + result, instruction.toString());
    }
}