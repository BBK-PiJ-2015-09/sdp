import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControlUnitTest {

  @Test
  public void testAdd() {
    ControlUnit controller = new ControlUnit();
    controller.add(new FireSensor());
    assertEquals(1, controller.sensors.size());
  }

}
