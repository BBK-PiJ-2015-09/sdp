package worksheet_02;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
		// Setup.
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    
	    // Test.
		ClassReader.printClass(input);
		assert(outContent.toString().length() > 0);
		
		// Teardown.
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test public void testGetSimpleName() throws ClassNotFoundException {
		assertEquals(ClassReader.getSimpleName(inputClass), "String");
	}
	
	@Test public void testGetModifiers() throws ClassNotFoundException {
		assertEquals(ClassReader.getModifiers(inputClass), 17);
	}

	@Test public void testGetConstructor() throws ClassNotFoundException {
		Constructor[] result = inputClass.getConstructors();
		assertArrayEquals(ClassReader.getConstructors(inputClass), result);
	}
	
	@Test public void testGetMethods() throws ClassNotFoundException {
		Method[] result = inputClass.getMethods();
		assertArrayEquals(ClassReader.getMethods(inputClass), result);
	}
	
	@Test public void getFields() throws ClassNotFoundException {
		Field[] result = inputClass.getFields();
		assertArrayEquals(ClassReader.getFields(inputClass), result);
	}
	
}
