package worksheet_02;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Scanner;

public class ClassReader {
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a class name:");
		String input = s.next();
		Class inputClass = Class.forName(input);
		
		String simpleName = inputClass.getSimpleName();
		System.out.println("Simple class name: " + simpleName);
		
        Constructor[] constructors = inputClass.getConstructors();
        System.out.println("Constructors: " + Arrays.toString(constructors));
		
		s.close();
	}
}
