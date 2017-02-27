import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutInstructionTest {

    String label = "label";
    int register = 0;
    Instruction instruction;

    @Before
    public void buildInstruction() {
        instruction = new OutInstruction(label, register);
    }

    @Test
    public void test_executeDoesNotThrowError() {
        Machine m = new Machine();
        Registers registers = new Registers();
        m.setRegisters(registers);
        instruction.execute(m);
    }

}