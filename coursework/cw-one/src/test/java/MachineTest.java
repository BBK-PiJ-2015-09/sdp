import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MachineTest {

    @Test
    public void test_execute() {
        Labels labels = new Labels();
        String label = "L1";
        labels.addLabel(label);

        int register = 0;
        int value = 23;
        Instruction ins = new LinInstruction(label, register, value);

        ArrayList prog = new ArrayList<>();
        prog.add(ins);

        Machine m = new Machine();
        m.setLabels(labels);
        m.setProg(prog);
        m.execute();

        assertEquals(value, m.getRegisters().getRegister(register));
    }

}