import java.time.LocalDateTime;
import java.util.List;

public class SecurityControlUnit extends ControlUnit {

  public SecurityControlUnit(List<Sensor> sensors) {
    super(sensors);
  }

  @Override
  public void pollSensors() {
    if (active()) {
      for (Sensor sensor : sensors) {
        if (sensor.isTriggered()) {
          System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
        } else {
          System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
        }
      }
    }
  }

  private boolean active() {
    return currentTime().isAfter(dawn()) && currentTime().isBefore(dusk());
  }

  private LocalDateTime dawn() {
    return currentTime().withHour(06).withMinute(00).withSecond(00);
  }

  private LocalDateTime dusk() {
    return currentTime().withHour(22).withMinute(00).withSecond(00);
  }

  public LocalDateTime currentTime() {
    return LocalDateTime.now();
  }

}
