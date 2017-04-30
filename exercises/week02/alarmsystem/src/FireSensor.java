public class FireSensor implements Sensor {
  private double battery = 100;
  private int history = 1;

  @Override
  public boolean isTriggered() {
    incrementHistory();
    return history == 1;
  }

  @Override
  public String getLocation() {
    return "Hallway";
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
      return battery -= 10;
    }
  }

  private void incrementHistory() {
      if (history == 20) {
          history = 1;
      } else {
          history++;
      }
  }
}
