import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepeaterTest {

  @Test
  public void testIsSometimesTriggered() {
    int rate = 20;
    int trueCount = 0;

    Repeater repeater = new Repeater(rate);

    for(int i = 1; i <= rate; i++) {
      if(repeater.call()) {
        trueCount++;
      }
    }
    assertEquals(1, trueCount);
  }

}
