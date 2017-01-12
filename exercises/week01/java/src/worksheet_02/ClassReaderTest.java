package worksheet_02;

import static org.junit.Assert.*;

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
		ClassReader.printClass(input);
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
