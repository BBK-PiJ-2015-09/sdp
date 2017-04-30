public class FireSensor implements Sensor {
  private double battery = 100;
  private Trigger trigger = new Trigger(20);

  @Override
  public boolean isTriggered() {
    return trigger.call();
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

}
