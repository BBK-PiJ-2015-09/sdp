package strategy

object TestStrategyPattern extends App {
  // 1. a) The strategy pattern allows the 'injection' of a strategy into an object, to give it different behaviour at runtime.
  //    b) It makes sense to use the strategy pattern when an object has different, distinct behaviours.

  var formatter: TextFormatter = CapTextFormatter()
  var editor: TextEditor = TextEditor(formatter)
  editor.publishText("Testing text in caps formatter")
  formatter = LowerTextFormatter()
  editor = TextEditor(formatter)
  editor.publishText("Testing text in lower formatter")
}
