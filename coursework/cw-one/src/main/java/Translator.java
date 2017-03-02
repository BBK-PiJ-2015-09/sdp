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

    // line should consist of an MML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (line.equals(""))
            return null;

        String ins = capitalise(scan());
        Class klass = Class.forName(ins + "Instruction");
        int int1 = scanInt();
        int int2 = scanInt();
        int int3 = scanInt();
        String label2 = scan();
        
        Class[] parameters0 = {String.class, int.class, String.class};
        Class[] parameters1 = {String.class, int.class};
        Class[] parameters2 = {String.class, int.class, int.class};
        Class[] parameters3 = {String.class, int.class, int.class, int.class};

        Constructor constructor = klass.getConstructors()[1];

        Class[] actual_parameters = constructor.getParameterTypes();

        if (Arrays.equals(actual_parameters, parameters0)) {
            return (Instruction) klass.getConstructors()[1].newInstance(label, int1, label2);
        } else if (Arrays.equals(actual_parameters, parameters1)) {
            return (Instruction) klass.getConstructors()[1].newInstance(label, int1);
        } else if (Arrays.equals(actual_parameters, parameters2)) {
            return (Instruction) klass.getConstructors()[1].newInstance(label, int1, int2);
        } else if (Arrays.equals(actual_parameters, parameters3)) {
            return (Instruction) klass.getConstructors()[1].newInstance(label, int1, int2, int3);
        }
        return null;
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
