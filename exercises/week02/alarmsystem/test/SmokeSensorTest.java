import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmokeSensorTest {
  SmokeSensor sensor = new SmokeSensor();

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
  public void testBatteryDrains() {
    int attempts = 5;
    int expectedLevel = 100;
    for(int i = 1; i <= attempts; i++) {
      expectedLevel -= 20;
      assertEquals(expectedLevel, sensor.getBatteryPercentage(), 0);
    }
  }

}
