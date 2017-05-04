import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class SecurityControlUnitTest {

  @Test
  public void testConstructor() {
    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new MotionSensor(Arrays.asList(new NoiseStrategy())));
    ControlUnit controller = new SecurityControlUnit(sensors);
    assertEquals(1, controller.sensors.size());
  }

  @Test
  public void testDaytime() {
    List<Sensor> sensors = new ArrayList<>();
    Sensor sensor = mock(MotionSensor.class);
    sensors.add(sensor);
    SecurityControlUnit controller = new SecurityControlUnit(sensors);

    SecurityControlUnit spy = spy(controller);
    LocalDateTime day = LocalDateTime.now().withHour(8).withMinute(00).withSecond(00);
    doReturn(day).when(spy).currentTime();

    spy.pollSensors();
    verify(sensor, times(1)).isTriggered();
  }

  @Test
  public void testNighttime() {
    List<Sensor> sensors = new ArrayList<>();
    Sensor sensor = mock(MotionSensor.class);
    sensors.add(sensor);
    SecurityControlUnit controller = new SecurityControlUnit(sensors);

    SecurityControlUnit spy = spy(controller);
    LocalDateTime night = LocalDateTime.now().withHour(23).withMinute(00).withSecond(00);
    doReturn(night).when(spy).currentTime();

    spy.pollSensors();
    verify(sensor, times(0)).isTriggered();
  }

}
