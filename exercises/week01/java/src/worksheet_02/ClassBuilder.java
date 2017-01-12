package worksheet_02;

public class ClassBuilder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a class name:");
		String input = s.next();
		System.out.println(input);
		s.close();
	}
	
	public static void buildClass(String input) throws ClassNotFoundException {
		Class inputClass = Class.forName(input);
	}
}
