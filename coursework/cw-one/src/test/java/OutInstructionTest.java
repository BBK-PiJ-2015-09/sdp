import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutInstructionTest {

    String label = "label";
    String opcode = "out";
    int register = 0;
    int value = 1;
    Instruction instruction;

    @Before
    public void buildInstruction() {
        instruction = new OutInstruction(label, register, value);
    }

    @Test
    public void test_executeDoesNotThrowError() {
        Machine m = new Machine();
        Registers registers = new Registers();
        m.setRegisters(registers);
        instruction.execute(m);
    }

}