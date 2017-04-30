import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmokeSensorTest {

  @Test
  public void testIsSometimesTriggered() {
    SmokeSensor sensor = new SmokeSensor();
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
    SmokeSensor sensor = new SmokeSensor();
    String location = sensor.getLocation();
    assertEquals("Kitchen", location);
  }

  @Test
  public void testGetSensorType() {
    SmokeSensor sensor = new SmokeSensor();
    String sensorType = sensor.getSensorType();
    assertEquals("SmokeSensor", sensorType);
  }

  @Test
  public void testBatteryDrains() {
    SmokeSensor sensor = new SmokeSensor();
    int attempts = 5;
    int expectedLevel = 100;
    for(int i = 1; i <= attempts; i++) {
      expectedLevel -= 20;
      assertEquals(expectedLevel, sensor.getBatteryPercentage(), 0);
    }
  }
  
  @Test
  public void testBatteryBottom() {
    SmokeSensor sensor = new SmokeSensor();
    int attempts = 20;
    int expectedLevel = 0;
    for(int i = 1; i <= attempts; i++) {
      sensor.getBatteryPercentage();
    }
    assertEquals(expectedLevel, sensor.getBatteryPercentage(), 0);
  }

}
