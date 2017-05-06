package observer

case class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String): Unit = {
    println(desc + " sent to " + msg)
  }

  def subscribe(): Unit = {
    s.subscribeObserver(this)
  }

  def unSubscribe() = ???
}
