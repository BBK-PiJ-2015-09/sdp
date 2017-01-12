package worksheet_02;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClassBuilderTest {
	Class inputClass;
	String input;
	
	@Before public void setup() throws ClassNotFoundException {
		input = "java.lang.String";
		inputClass = Class.forName(input);
	}

	@Test public void consolePrintClass() throws ClassNotFoundException {
		ClassBuilder.buildClass(input);
	}
	
}
