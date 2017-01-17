package worksheet_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
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
	
	public static String buildClass(String input, char[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class inputClass = Class.forName(input);
		Constructor[] constructors = inputClass.getConstructors();
		
		// Get the relevant constructor.
		Constructor constructor = constructors[0];
		for(int i = 0; i < constructors.length; i++) {
			if (constructors[i].getParameters().length == 1 && constructors[i].getParameters()[0].getType() == char[].class) {
				constructor = constructors[i];
				break;
			}
		}	
		System.out.println(constructor.toString());
		return (String) constructor.newInstance(args);
	}
}
