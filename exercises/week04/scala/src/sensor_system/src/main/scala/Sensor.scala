package sensor_system

/** Sensor interface. */
trait Sensor {
  /** Returns true/false for whether the sensor is
    * triggered or not.
    *
    *  @return a boolean for whether the sensor is triggered
    */
  def isTriggered

  /** Returns a description of the location of the
    * sensor such as "Lobby 1st floor" or "In the auditorium".
  *
  *  @return a description of the location
  */
  def getLocation

  /** Returns a textual description of the
    * sensor type such as "Fire sensor" or "Smoke sensor".
    *
    *  @return a description of the sensor type
    */
  def getSensortype

  /** Returns number between 0-100 where 0 is empty and
    * 100 is fully charged.
    *
    *  @return an integer indicating the charge percentage
    */
  def getBatteryPercentage
}
