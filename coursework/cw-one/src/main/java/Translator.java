import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
        int s1; // Possible operands of the instruction
        int s2;
        int r;
        int x;
        int parameters;
        Constructor<?>[] constructors;
        Constructor constructor;

        if (line.equals(""))
            return null;

        String ins = scan();
        ins = capitalise(ins);
        switch (ins) {
            case "Add":
            case "Sub":
            case "Mul":
            case "Div":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                parameters = 4;
                constructors = Class.forName(ins + "Instruction").getConstructors();
                constructor = constructors[0];
                for(int i = 0; i < constructors.length; i++) {
                    if (constructors[i].getParameters().length == parameters) {
                        constructor = constructors[i];
                    }
                }
                return (Instruction) constructor.newInstance(label, r, s1, s2);
            case "Lin":
                r = scanInt();
                s1 = scanInt();
                parameters = 3;
                constructors = Class.forName(ins + "Instruction").getConstructors();
                constructor = constructors[0];
                for(int i = 0; i < constructors.length; i++) {
                    if (constructors[i].getParameters().length == parameters) {
                        constructor = constructors[i];
                    }
                }
                return (Instruction) constructor.newInstance(label, r, s1);
            case "Bnz":
                s1 = scanInt();
                parameters = 3;
                constructors = Class.forName(ins + "Instruction").getConstructors();
                constructor = constructors[0];
                for(int i = 0; i < constructors.length; i++) {
                    if (constructors[i].getParameters().length == parameters) {
                        constructor = constructors[i];
                    }
                }
                return (Instruction) constructor.newInstance(label, s1, scan());
            case "Out":
                s1 = scanInt();
                parameters = 2;
                constructors = Class.forName(ins + "Instruction").getConstructors();
                constructor = constructors[0];
                for(int i = 0; i < constructors.length; i++) {
                    if (constructors[i].getParameters().length == parameters) {
                        constructor = constructors[i];
                    }
                }
                return (Instruction) constructor.newInstance(label, s1);
        }

        // You will have to write code here for the other instructions.

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
