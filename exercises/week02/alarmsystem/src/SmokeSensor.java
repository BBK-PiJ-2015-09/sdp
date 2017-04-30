public class SmokeSensor implements Sensor {
  private double battery = 100;
  private Trigger trigger = new Trigger(10);

  @Override
  public boolean isTriggered() {
    return trigger.call();
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

}
