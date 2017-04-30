public class SmokeSensor implements Sensor {
  private double battery = 100;
  private int history = 1;

  @Override
  public boolean isTriggered() {
    incrementHistory();
    return history == 1;
  }

  @Override
  public String getLocation() {
    return "Kitchen";
  }

  @Override
  public String getSensorType() {
    return getClass().getSimpleName();
  }

  @Override
  public double getBatteryPercentage() {
    if (battery == 0) {
      return battery;
    } else {
      return battery -= 20;
    }
  }

  private void incrementHistory() {
    if (history == 10) {
      history = 1;
    } else {
      history++;
    }
  }
}
