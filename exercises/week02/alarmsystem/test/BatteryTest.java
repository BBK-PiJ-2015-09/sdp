import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatteryTest {
  Battery battery = new Battery(10);

  @Test
  public void testBatteryDrains() {
    int calls = 10;
    int expectedLevel = 100;
    for(int i = 1; i <= calls; i++) {
      expectedLevel -= 10;
      assertEquals(expectedLevel, battery.call(), 0);
    }
  }

  @Test
  public void testBatteryBottom() {
    int calls = 10;
    int expectedLevel = 0;
    for(int i = 1; i <= calls; i++) {
      battery.call();
    }
    assertEquals(expectedLevel, battery.call(), 0);
  }

}
