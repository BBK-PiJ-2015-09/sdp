package worksheet_02;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class StudentClassTest {

	@Test
	public void testMaxFourFields() {
		StudentClass sclass = new StudentClass();		
		assertTrue(sclass.getClass().getFields().length <= 4);
	}

}
