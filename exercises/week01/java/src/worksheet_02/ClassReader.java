package worksheet_02;

import java.util.Scanner;

public class ClassReader {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a class name:");
		String className = s.next();		
		System.out.println(className);
		s.close();
	}
}
