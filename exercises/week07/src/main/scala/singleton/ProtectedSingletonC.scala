package singleton

object ProtectedSingletonC {
  def lowercase() : String = synchronized { "c" }
  def uppercase() : String = synchronized { "C" }
}
