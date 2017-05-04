import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SecurityControlUnitTest {

  @Test
  public void testConstructor() {
    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new MotionSensor());
    ControlUnit controller = new SecurityControlUnit(sensors);
    assertEquals(1, controller.sensors.size());
  }

}
