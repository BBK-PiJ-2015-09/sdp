public class BnzInstruction extends Instruction {
    private int register;
    private String next_label;

    public BnzInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public BnzInstruction(String label, int register, String next_label) {
        super(label, "bnz");
        this.register = register;
        this.next_label = next_label;
    }

    @Override
    public void execute(Machine m) {
        m.setPc(0);
    }

    @Override
    public String toString() {
        return super.toString() + " next label is " + next_label;
    }
}
