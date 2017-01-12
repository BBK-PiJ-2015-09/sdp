package worksheet_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClassReaderTest {
	
	Class inputClass;
	String input;
	
	@Before public void setup() throws ClassNotFoundException {
		input = "java.lang.String";
		inputClass = Class.forName(input);
	}
	
	@Test public void testPrintClass() throws ClassNotFoundException {
		ClassReader.printClass(input);
	}

	@Test public void testGetSimpleName() throws ClassNotFoundException {
		assertEquals(ClassReader.getSimpleName(inputClass), "String");
	}
	
	@Test public void testGetModifiers() throws ClassNotFoundException {
		assertEquals(ClassReader.getModifiers(inputClass), 17);
	}
	
}
