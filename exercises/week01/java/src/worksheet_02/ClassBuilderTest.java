package worksheet_02;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClassBuilderTest {
	String input;
	char[] args;
	
	@Before public void setup() throws ClassNotFoundException {
		input = "java.lang.String";
		args = new char[]{'H','e','l','l','o', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
	}

	@Test public void testBuildClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		assertEquals("Hello world!", ClassBuilder.buildClass(input, args));
	}
	
}
