package sensor_system

/** Sensor interface. */
trait Sensor {
  def isTriggered
  def getLocation
  def getSensortype
  def getBatteryPercentage
}
