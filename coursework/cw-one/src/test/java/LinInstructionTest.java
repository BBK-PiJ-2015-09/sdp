import org.junit.*;
import static org.junit.Assert.*;

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

        assertEquals(m.getRegisters().getRegister(register), value);
    }

    @Test
    public void test_toString() {
        assertEquals(instruction.toString(), label + ": " + opcode + " register " + register + " value is " + value);
    }
}