import static org.junit.Assert.assertEquals;

public class MathsInstructionTest {

    int result = 0;
    int op1 = 1;
    int op2 = 2;
    int val1 = 1;
    int val2 = 2;

    public void test_execute(Instruction instruction, int sum) {
        Machine m = new Machine();
        Registers registers = new Registers();
        m.setRegisters(registers);
        m.getRegisters().setRegister(op1, val1);
        m.getRegisters().setRegister(op2, val2);
        instruction.execute(m);

        assertEquals(sum, m.getRegisters().getRegister(result));
    }

}