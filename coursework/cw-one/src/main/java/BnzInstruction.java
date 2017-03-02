public class BnzInstruction extends Instruction {
    private int register;
    private String next_label;

    public BnzInstruction(String label, int register, String next_label) {
        super(label, "bnz");
        this.register = register;
        this.next_label = next_label;
    }

    @Override
    public void execute(Machine m) {
        if (m.getRegisters().getRegister(register) != 0) {
            m.setPc(m.getLabels().indexOf(next_label));
        }
    }

    @Override
    public String toString() {
        return super.toString() + " next label is " + next_label;
    }
}
