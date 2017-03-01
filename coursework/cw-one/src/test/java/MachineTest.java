import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void test_translateFromFile() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Machine m = new Machine();
        Translator t = new Translator("SML/out/production/SML/test2.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());

        assertThat(m.getProg().get(0), instanceOf(LinInstruction.class));
        assertThat(m.getProg().get(1), instanceOf(LinInstruction.class));
        assertThat(m.getProg().get(2), instanceOf(LinInstruction.class));
        assertThat(m.getProg().get(3), instanceOf(MulInstruction.class));
        assertThat(m.getProg().get(4), instanceOf(SubInstruction.class));
        assertThat(m.getProg().get(5), instanceOf(BnzInstruction.class));
        assertThat(m.getProg().get(6), instanceOf(OutInstruction.class));
    }

    @Test
    public void test_translateFromFileDiv() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Machine m = new Machine();
        Translator t = new Translator("SML/out/production/SML/test3.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());

        assertThat(m.getProg().get(0), instanceOf(LinInstruction.class));
        assertThat(m.getProg().get(1), instanceOf(LinInstruction.class));
        assertThat(m.getProg().get(2), instanceOf(DivInstruction.class));
    }
}