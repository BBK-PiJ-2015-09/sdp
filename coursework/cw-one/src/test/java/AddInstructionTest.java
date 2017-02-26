import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddInstructionTest {

    String label = "label";
    String opcode = "add";
    int result = 0;
    int op1 = 1;
    int op2 = 2;
    int val1 = 1;
    int val2 = 2;
    int sum  = val1 + val2;
    Instruction instruction;

    @Before
    public void buildInstruction() {
        instruction = new AddInstruction(label, result, op1, op2);
    }

    @Test
    public void test_execute() {
        Machine m = new Machine();
        Registers registers = new Registers();
        m.setRegisters(registers);
        m.getRegisters().setRegister(op1, val1);
        m.getRegisters().setRegister(op2, val2);
        instruction.execute(m);

        assertEquals(op1 + op2, m.getRegisters().getRegister(result));
    }

    @Test
    public void test_toString() {
        assertEquals(label + ": " + opcode + " " + op1 + " + " + op2 + " to " + result, instruction.toString());
    }
}