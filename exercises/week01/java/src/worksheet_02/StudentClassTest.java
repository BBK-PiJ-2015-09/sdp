package worksheet_02;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StudentClassTest {
	Class sclass;
	Field[] fields;
	
	@Before 
	public void setup() {
		sclass = new StudentClass().getClass();
	}
	
	@Test
	public void testMaxFourFields() {
		fields = sclass.getDeclaredFields();
		assertTrue(fields.length <= 4);
	}

	@Test
	public void testAllFieldsPrivate() {
		fields = sclass.getFields();
		assertTrue(fields.length == 0);
	}
	
	@Test
	public void testNoArrayList() {
		fields = sclass.getDeclaredFields();
		boolean noArrayList = true;
		for(int i = 0; i < fields.length; i++) {
			if(fields[i].getType() == new ArrayList<String>().getClass()) {
				noArrayList = false;
				break;
			}
		}
		assertTrue(noArrayList);
	}
	
}
