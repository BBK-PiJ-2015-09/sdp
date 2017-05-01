public class SmokeSensor implements BatterySensor {
  private Battery battery = new Battery(20);
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
    return battery.call();
  }

}
