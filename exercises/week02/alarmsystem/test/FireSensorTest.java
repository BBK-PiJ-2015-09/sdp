import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireSensorTest {
  FireSensor sensor = new FireSensor();

  @Test
  public void testIsSometimesTriggered() {
    int attempts = 20;
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
    assertEquals("FireSensor", sensorType);
  }

  @Test
  public void testBatteryDrains() {
    int attempts = 10;
    int expectedLevel = 100;
    for(int i = 1; i <= attempts; i++) {
      expectedLevel -= 10;
      assertEquals(expectedLevel, sensor.getBatteryPercentage(), 0);
    }
  }

  @Test
  public void testBatteryBottom() {
    int attempts = 20;
    int expectedLevel = 0;
    for(int i = 1; i <= attempts; i++) {
      sensor.getBatteryPercentage();
    }
    assertEquals(expectedLevel, sensor.getBatteryPercentage(), 0);
  }
}
