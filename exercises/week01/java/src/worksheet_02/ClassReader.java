package worksheet_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class ClassReader {
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a class name:");
		String input = s.next();
		printClass(input);
		s.close();
	}
	
	public static void printClass(String input) throws ClassNotFoundException {
		Class inputClass = Class.forName(input);
		
		String simpleName = inputClass.getSimpleName();
		System.out.println("Simple class name: " + simpleName);
        
        System.out.println("Modifiers: " + getModifiers(inputClass));
		
        Constructor[] constructors = inputClass.getConstructors();
        System.out.println("Constructors: " + Arrays.toString(constructors));
		
        Method[] methods = inputClass.getMethods();
        System.out.println("Methods: " + Arrays.toString(methods));

	}
	
	public static int getModifiers(Class inputClass) {
		return inputClass.getModifiers();
	}
	
}
