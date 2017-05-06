package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject {
  private var desc: String = _

  def subscribeObserver(observer: Observer): Unit = {
    subscribers += observer
  }

  def unSubscribeObserver(observer: Observer) = ???

  def notifyObservers(): Unit = {
    for(subscriber <- subscribers) {
      subscriber.update(desc)
    }
  }

  def subjectDetails: String = ???

  def setDesc(_desc: String): Unit = {
    desc = _desc
    notifyObservers()
  }
}
