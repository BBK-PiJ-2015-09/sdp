import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireStrategyTest {
  FireStrategy alarm = new FireStrategy();

  @Test
  public void testActivate() {
    alarm.activate();
    assertEquals(true, alarm.active());
  }

  @Test
  public void testDeactivate() {
    alarm.activate();
    alarm.deactivate();
    assertEquals(false, alarm.active());
  }

}
