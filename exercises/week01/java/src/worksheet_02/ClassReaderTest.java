package worksheet_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassReaderTest {

	@Test
	public void testprintClass() throws ClassNotFoundException {
		String input = "java.lang.String";
		ClassReader.printClass(input);
	}

	@Test
	public void testgetModifiers() throws ClassNotFoundException {
		String input = "java.lang.String";
		Class inputClass = Class.forName(input);

		assertEquals(ClassReader.getModifiers(inputClass), 17);
	}
	
}
