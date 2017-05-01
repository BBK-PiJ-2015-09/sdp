public interface Sensor {
  boolean isTriggered();

  String getLocation();

  String getSensorType();

  String getSensorPurpose();
}
