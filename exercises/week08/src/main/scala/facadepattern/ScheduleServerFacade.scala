package facadepattern

case class ScheduleServerFacade(scheduleServer: ScheduleServer) {
  def stopServer: Unit = {
    scheduleServer.releaseProcesses
    scheduleServer.destroy
    scheduleServer.destroySystemObjects
    scheduleServer.destroyListeners
    scheduleServer.destroyContext
    scheduleServer.shutdown
  }

  def startServer: Unit = {
    scheduleServer.startBooting
    scheduleServer.readSystemConfigFile
    scheduleServer.init
    scheduleServer.initializeContext
    scheduleServer.initializeListeners
    scheduleServer.createSystemObjects
  }

}
