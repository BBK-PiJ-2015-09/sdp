package worksheet_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentClassTest {

	@Test
	public void testMaxFourFields() {
		StudentClass sclass = new StudentClass();
		assert(sclass.getClass().getFields().length <= 4);
	}

}
