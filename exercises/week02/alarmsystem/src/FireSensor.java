import java.util.Random;

public class FireSensor implements Sensor {
  private int history = 1;

  @Override
  public boolean isTriggered() {
    incrementHistory();
    return history == 1;
  }

  @Override
  public String getLocation() {
    return null;
  }

  @Override
  public String getSensorType() {
    return null;
  }

  @Override
  public double getBatteryPercentage() {
    return -1;
  }

  private void incrementHistory() {
      if (history == 20) {
          history = 1;
      } else {
          history++;
      }
  }
}
