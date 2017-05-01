public class MotionSensor implements Sensor {
  private Trigger trigger = new Trigger(4);

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
  public String getSensorPurpose() { return "Security"; }

}
