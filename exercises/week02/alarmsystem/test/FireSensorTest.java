import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FireSensorTest {

  @Test
  public void testIsSometimesTriggered() {
    FireSensor sensor = new FireSensor();
    int attempts = 20;
    int trueCount = 0;
    for(int i = 1; i <= attempts; i++) {
        if(sensor.isTriggered()) {
            trueCount++;
        }
    }
    assertEquals(1, trueCount);
  }

//  @Test
//  public void testThatGetLocationReturnsNull() {
//    FireSensor sensor = new FireSensor();
//    String location = sensor.getLocation();
//    assertEquals(null, location);
//  }
//
//  @Test
//  public void testThatGetSensorTypeReturnsNull() {
//    FireSensor sensor = new FireSensor();
//    String sensorType = sensor.getSensorType();
//    assertEquals(null, sensorType);
//  }

  @Test
  public void testBatteryDrains() {
    FireSensor sensor = new FireSensor();
    int attempts = 10;
    int expectedLevel = 100;
    for(int i = 1; i <= attempts; i++) {
      expectedLevel -= 10;
      assertEquals(expectedLevel, sensor.getBatteryPercentage(), 0);
    }
  }
}
