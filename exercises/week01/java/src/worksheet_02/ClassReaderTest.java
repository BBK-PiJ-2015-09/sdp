package worksheet_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassReaderTest {

	@Test
	public void testPrintClass() {
		String input = "java.lang.String";
		try {
			ClassReader.printClass(input);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
