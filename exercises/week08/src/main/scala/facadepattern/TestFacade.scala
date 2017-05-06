package facadepattern

object TestFacade {
  // 7. a) The facade pattern is a way of hiding implementation details which have become cumbersome
  // behind a wrapper object.
  // b) You might use this when attempting to update a legacy system - you could immediately add the interface
  // you want, and then gradually refactor the implementation behind the facade.

  def main(args: Array[String]) {
    val scheduleServer: ScheduleServer = ScheduleServerImpl()
    val facadeServer: ScheduleServerFacade = ScheduleServerFacade(scheduleServer)
    println("Start working......")
    facadeServer.startServer
    println("After work done.........")
    facadeServer.stopServer
  }
}
