import org.junit.*;
import static org.junit.Assert.*;

public class LinInstructionTest {

    @Test
    public void test_toString() {
        String label = "label";
        String opcode = "lin";
        Integer register = 0;
        Integer value = 0;
        Instruction instruction = new LinInstruction(label, register, value);

        assertEquals(instruction.toString(), label + ": " + opcode + " register " + register + " value is " + value);
    }
}