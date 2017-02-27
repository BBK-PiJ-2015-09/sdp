import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BnzInstructionTest {

    String label = "label";
    String opcode = "bnz";
    int register = 1;
    String next_label = "next_label";
    Instruction instruction;

    @Before
    public void buildInstruction() {
        instruction = new BnzInstruction(label, register, next_label);
    }

    @Test
    public void test_execute() {
        Machine m = new Machine();
        Registers registers = new Registers();
        m.setRegisters(registers);
        instruction.execute(m);

        // assertEquals(index of next_label in prog, m.getPc())
        assertEquals(0, m.getPc());
    }

    @Test
    public void test_toString() {
        assertEquals(label + ": " + opcode + " next label is " + next_label, instruction.toString());
    }
}