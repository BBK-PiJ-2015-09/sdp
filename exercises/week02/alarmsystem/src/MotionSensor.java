import java.util.List;

public class MotionSensor implements Sensor {
  private Trigger trigger = new Trigger(4);
  private List<AlarmStrategy> strategies;

  public MotionSensor(List<AlarmStrategy> strategies) {
    this.strategies = strategies;
  }

  @Override
  public boolean isTriggered() {
    boolean triggered = trigger.call();
    if (triggered) { for(AlarmStrategy alarm : strategies) { alarm.activate(); } }
    return triggered;
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
