import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriggerTest {

  @Test
  public void testIsSometimesTriggered() {
    int rate = 20;
    int trueCount = 0;

    Trigger trigger = new Trigger(rate);

    for(int i = 1; i <= rate; i++) {
      if(trigger.call()) {
        trueCount++;
      }
    }
    assertEquals(1, trueCount);
  }

}
