package worksheet_02;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Scanner;

public class ClassBuilder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a class name:");
		String input = s.next();
		System.out.println(input);
		s.close();
	}
	
	public static String buildClass(String input, char[] args) throws ClassNotFoundException {
		Class inputClass = Class.forName(input);
		Constructor[] constructors = inputClass.getConstructors();
		System.out.println("Constructors: " + Arrays.toString(constructors));
		// Get the relevant constructor.
		// Call it on inputClass with the args.
//		inputClass.newInstance();
		return "";
	}
}
