import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
  List<Sensor> sensors = new ArrayList<Sensor>();

  public void add(Sensor sensor) {
    sensors.add(sensor);
  }

  public void pollSensors() {
    for (Sensor sensor : sensors) {
      if (sensor.isTriggered()) {
        System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
      } else {
        System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
      }
    }
  }
}
