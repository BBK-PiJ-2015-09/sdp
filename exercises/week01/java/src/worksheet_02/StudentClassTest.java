package worksheet_02;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class StudentClassTest {
	StudentClass sclass;
	Field[] fields;
	
	@Before 
	public void setup() {
		sclass = new StudentClass();
		fields = sclass.getClass().getFields();
	}
	
	@Test
	public void testMaxFourFields() {
		assertTrue(fields.length <= 4);
	}

	@Test
	public void testAllFieldsPrivate() {
		assertTrue(sclass.getClass().getFields().length == 0);
	}
	
}
