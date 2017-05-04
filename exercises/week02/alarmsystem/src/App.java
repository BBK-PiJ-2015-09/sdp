import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
  private static final String EXIT = "exit";
  private static final String POLL = "poll";

  public static void main(String[] args) throws IOException {
    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new FireSensor(Arrays.asList(new FireStrategy())));
    sensors.add(new SmokeSensor());
    ControlUnit controlUnit = new ControlUnit(sensors);

    List<Sensor> securitySensors = new ArrayList<>();
    securitySensors.add(new MotionSensor());
    ControlUnit securityControlUnit = new SecurityControlUnit(securitySensors);

    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals(EXIT)) {
      System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
      input = scanner.nextLine();
      if (input.equals(POLL)) {
        controlUnit.pollSensors();
        securityControlUnit.pollSensors();
      }
    }
  }
}
