import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinInstructionTest {

    String label = "label";
    String opcode = "lin";
    int register = 0;
    int value = 23;
    Instruction instruction;

    @Before
    public void buildInstruction() {
        instruction = new LinInstruction(label, register, value);
    }

    @Test
    public void test_execute() {
        Machine m = new Machine();
        Registers registers = new Registers();
        m.setRegisters(registers);
        instruction.execute(m);

        assertEquals(value, m.getRegisters().getRegister(register));
    }

    @Test
    public void test_toString() {
        assertEquals(label + ": " + opcode + " register " + register + " value is " + value, instruction.toString());
    }
}