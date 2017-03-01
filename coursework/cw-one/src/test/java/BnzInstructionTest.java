import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BnzInstructionTest {
    String opcode = "bnz";

    String label1 = "L1";
    String label2 = "L2";
    String label3 = "L3";
    String label4 = "L4";
    String label5 = "L5";

    int register1 = 0;
    int register2 = 1;
    int value1 = 4;
    int subtract_value = 1;

    Instruction ins1 = new LinInstruction(label1, register1, value1);
    Instruction ins2 = new LinInstruction(label2, register2, subtract_value);
    Instruction ins3 = new SubInstruction(label3, register1, register1, register2);
    Instruction bnz1 = new BnzInstruction(label4, register1, label3);
    Instruction bnz2 = new BnzInstruction(label4, register1, label5);
    Instruction ins4 = new OutInstruction(label5, register1);

    @Test
    public void test_execute() {
        Labels labels = new Labels();
        labels.addLabel(label1);
        labels.addLabel(label2);
        labels.addLabel(label3);
        labels.addLabel(label4);

        ArrayList prog = new ArrayList<>();
        prog.add(ins1);
        prog.add(ins2);
        prog.add(ins3);
        prog.add(bnz1);

        Machine m = new Machine();
        m.setLabels(labels);
        m.setProg(prog);

        m.execute();

        assertEquals(0, m.getRegisters().getRegister(0));
    }

    @Test
    public void test_executeBranchToDifferentLabel() {
        Labels labels = new Labels();
        labels.addLabel(label1);
        labels.addLabel(label2);
        labels.addLabel(label3);
        labels.addLabel(label4);
        labels.addLabel(label5);

        ArrayList prog = new ArrayList<>();
        prog.add(ins1);
        prog.add(ins2);
        prog.add(ins3);
        prog.add(bnz2);
        prog.add(ins4);

        Machine m = new Machine();
        m.setLabels(labels);
        m.setProg(prog);

        m.execute();

        assertEquals(3, m.getRegisters().getRegister(0));
    }

    @Test
    public void test_toString() {
        assertEquals(label4 + ": " + opcode + " next label is " + label3 , bnz1.toString());
    }
}