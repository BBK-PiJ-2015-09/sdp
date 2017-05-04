import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class SecurityControlUnitTest {

  @Test
  public void testConstructor() {
    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new MotionSensor());
    ControlUnit controller = new SecurityControlUnit(sensors);
    assertEquals(1, controller.sensors.size());
  }

  @Test
  public void testDaytime() {
    List<Sensor> sensors = new ArrayList<>();
    Sensor sensor = mock(MotionSensor.class);
    sensors.add(sensor);
    ControlUnit controller = new SecurityControlUnit(sensors);
    controller.pollSensors();
    verify(sensor, times(1)).isTriggered();
  }

  @Test
  public void testNighttime() {
    List<Sensor> sensors = new ArrayList<>();
    Sensor sensor = new MotionSensor();
    sensors.add(sensor);
    ControlUnit controller = new SecurityControlUnit(sensors);
    controller.pollSensors();
    verify(sensor, times(0)).isTriggered();
  }

}
