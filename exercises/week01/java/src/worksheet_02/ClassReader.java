package worksheet_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
		
		System.out.println("Simple class name: " + getSimpleName(inputClass));
        
        System.out.println("Modifiers: " + getModifiers(inputClass));
		
        System.out.println("Constructors: " + Arrays.toString(getConstructors(inputClass)));
		
        System.out.println("Methods: " + Arrays.toString(getMethods(inputClass)));
        
        System.out.println("Fields: " + Arrays.toString(getFields(inputClass)));

	}
	
	public static String getSimpleName(Class inputClass) {
		return inputClass.getSimpleName();
	}
	
	public static int getModifiers(Class inputClass) {
		return inputClass.getModifiers();
	}
	
	public static Constructor[] getConstructors(Class inputClass) {
		return inputClass.getConstructors();
	}
	
	public static Method[] getMethods(Class inputClass) {
		return inputClass.getMethods();
	}
	
	public static Field[] getFields(Class inputClass) {
		return inputClass.getFields();
	}
}
