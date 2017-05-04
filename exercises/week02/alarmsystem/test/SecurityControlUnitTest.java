import org.junit.Test;

import java.time.LocalDateTime;
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
    Sensor sensor = new MotionSensor();
    Sensor spy = spy(sensor);
    LocalDateTime day = LocalDateTime.of(2017, 05, 14, 8, 00, 00);
    when(spy.currentTime()).thenReturn(day);
    sensors.add(sensor);
    ControlUnit controller = new SecurityControlUnit(sensors);
    controller.pollSensors();
    verify(sensor, times(1)).isTriggered();
  }

  @Test
  public void testNighttime() {
    List<Sensor> sensors = new ArrayList<>();
    Sensor sensor = new MotionSensor();
    Sensor spy = spy(sensor);
    LocalDateTime night = LocalDateTime.of(2017, 05, 14, 23, 00, 00);
    when(spy.currentTime()).thenReturn(night);
    sensors.add(sensor);
    ControlUnit controller = new SecurityControlUnit(sensors);
    controller.pollSensors();
    verify(sensor, times(0)).isTriggered();
  }

}
