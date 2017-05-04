import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SmokeSensorTest {
  AlarmStrategy strategy = new FireStrategy();
  List<AlarmStrategy> strategies = Arrays.asList(strategy);
  SmokeSensor sensor = new SmokeSensor(strategies);

  @Test
  public void testStrategy() {
    int attempts = 20;
    for(int i = 1; i <= attempts; i++) { sensor.isTriggered(); }
    assertEquals(true, strategy.active());
  }

  @Test
  public void testIsSometimesTriggered() {
    int attempts = 10;
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
    assertEquals("Kitchen", location);
  }

  @Test
  public void testGetSensorType() {
    String sensorType = sensor.getSensorType();
    assertEquals("SmokeSensor", sensorType);
  }

  @Test
  public void testGetSensorPurpose() {
    String sensorPurpose = sensor.getSensorPurpose();
    assertEquals("Hazard", sensorPurpose);
  }

  @Test
  public void testBatteryDrains() {
    int attempts = 5;
    int expectedLevel = 100;
    for(int i = 1; i <= attempts; i++) {
      expectedLevel -= 20;
      assertEquals(expectedLevel, sensor.getBatteryPercentage(), 0);
    }
  }

}
