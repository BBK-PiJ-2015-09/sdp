import java.util.List;

public class SmokeSensor implements BatterySensor {
  private Battery battery = new Battery(20);
  private Trigger trigger = new Trigger(10);
  private List<AlarmStrategy> strategies;

  public SmokeSensor(List<AlarmStrategy> strategies) {
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
    return "Kitchen";
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
