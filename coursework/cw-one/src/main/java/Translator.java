import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Arrays;

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

    private static final String PATH = "/Users/birkbeck/Documents/workspace/sdp/coursework/cw-one/";
    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private String line = "";
    private Labels labels; // The labels of the program being translated
    private ArrayList<Instruction> program; // The program to be created
    private String fileName; // source file of SML code

    // Different param signatures for Instructions.
    private Class[] bnz_params = new Class[]{String.class, int.class, String.class};
    private Class[] one_int_params = new Class[]{String.class, int.class};
    private Class[] two_int_params = new Class[]{String.class, int.class, int.class};
    private Class[] three_int_params = new Class[]{String.class, int.class, int.class, int.class};

    public Translator(String fileName) {
        this.fileName = PATH + fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"
    public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        try (Scanner sc = new Scanner(new File(fileName))) {
            // Scanner attached to the file chosen by the user
            labels = lab;
            labels.reset();
            program = prog;
            program.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next line into line
            while (line != null) {
                // Store the label in label
                String label = scan();

                if (label.length() > 0) {
                    Instruction ins = getInstruction(label);
                    if (ins != null) {
                        labels.addLabel(label);
                        program.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.out.println("File: IO error " + ioE.getMessage());
            System.exit(-1);
            return false;
        }
        return true;
    }

    // line should consist of an SML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Instruction instance = null;
        if (!line.equals("")) {
            for (Constructor constructor : getConstructors()) {
                instance = getInstance(label, constructor);
            }
        }
        return instance;
    }

    /*
     * Return the constructors of the instruction.
     */
    private Constructor[] getConstructors() throws ClassNotFoundException {
        return getClass("Instruction").getConstructors();
    }

    /*
     * Return the class of the instruction.
     */
    private Class getClass(String postfix) throws ClassNotFoundException {
        return Class.forName(capitalise(scan()) + postfix);
    }

    /*
     * Return an instance of a constructor.
     */
    private Instruction getInstance(String label, Constructor constructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class[] params = constructor.getParameterTypes();
        if (Arrays.equals(params, bnz_params)) {
            return (Instruction) constructor.newInstance(label, scanInt(), scan());
        } else if (Arrays.equals(params, one_int_params)) {
            return (Instruction) constructor.newInstance(label, scanInt());
        } else if (Arrays.equals(params, two_int_params)) {
            return (Instruction) constructor.newInstance(label, scanInt(), scanInt());
        } else if (Arrays.equals(params, three_int_params)) {
            return (Instruction) constructor.newInstance(label, scanInt(), scanInt(), scanInt());
        } else {
            return null;
        }
    }

    /*
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0)
            return "";

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is
    // any error, return the maximum int
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }

    private String capitalise(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
