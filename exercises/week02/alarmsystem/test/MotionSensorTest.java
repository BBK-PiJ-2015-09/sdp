import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MotionSensorTest {
  AlarmStrategy noiseStrategy = new NoiseStrategy();
  List<AlarmStrategy> strategies = Arrays.asList(noiseStrategy);
  MotionSensor sensor = new MotionSensor(strategies);

  @Test
  public void testStrategy() {
    int attempts = 4;
    for(int i = 1; i <= attempts; i++) { sensor.isTriggered(); }
    assertEquals(true, noiseStrategy.active());
  }

  @Test
  public void testIsSometimesTriggered() {
    int attempts = 4;
    int trueCount = 0;
    for(int i = 1; i <= attempts; i++) {
        if(sensor.isTriggered()) {
            trueCount++;
        }
    }
    assertEquals(1, trueCount);
  }

  @Test
  public void testGetLocation() {
    String location = sensor.getLocation();
    assertEquals("Hallway", location);
  }

  @Test
  public void testGetSensorType() {
    String sensorType = sensor.getSensorType();
    assertEquals("MotionSensor", sensorType);
  }

  @Test
  public void testGetSensorPurpose() {
    String sensorPurpose = sensor.getSensorPurpose();
    assertEquals("Security", sensorPurpose);
  }

}
