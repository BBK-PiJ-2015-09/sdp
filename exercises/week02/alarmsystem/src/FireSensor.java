public class FireSensor implements BatterySensor {
  private Battery battery = new Battery(10);
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
  public String getSensorPurpose() { return "Hazard"; }

  @Override
  public double getBatteryPercentage() {
    return battery.call();
  }

}
