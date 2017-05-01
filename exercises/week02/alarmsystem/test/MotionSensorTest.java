import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MotionSensorTest {
  MotionSensor sensor = new MotionSensor();

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
