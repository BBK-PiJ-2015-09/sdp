package vm

import bc.ByteCode

/**
  * [[VirtualMachineImpl]] defines an implementation of [[VirtualMachine]].
  */
class VirtualMachineImpl extends VirtualMachine {
  var myStack = Vector[Int]()

  /**
    * Executes a vector of bytecodes.
    *
    * Note, that this is an "immutable" object. That is, it
    * will return a new virtual machine after executing each
    * of the bytecode objects in the vector.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  override def execute(bc: Vector[ByteCode]): VirtualMachine = {
    var myBC = bc
    for(i <- 1 to bc.length) {
      val pair = executeOne(myBC)
      myBC = pair._1
      myStack = pair._2.state
    }
    this
  }


  /**
    * Executes the next bytecode in the vector of bytecodes.
    *
    * This method only executes a single byte code in the vector of bytecodes.
    * It returns a tuple of the new vector of bytecodes (with the executed
    * bytecode removed) and the new virtual machine.
    *
    * You may assume that `bc` contains at least 1 bytecode.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */
  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
    val topBC = bc(0)
    val newBC = bc.drop(1)
    val newVC = topBC.execute(this)
    (newBC,newVC)
  }

  /**
    * Pushes an integer value onto the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  override def push(value: Int): VirtualMachine = {
    myStack = myStack.+:(value)
    this
  }

  /**
    * Pops an integer value off of the virtual machine stack.
    *
    * @return (i, vm), where i is the integer popped and vm is the
    *         new virtual machine
    */
  override def pop(): (Int, VirtualMachine) = {
    if(myStack isEmpty) throw new MachineUnderflowException("Stack empty, cannot pop!")

    val myInt = myStack(0)
    myStack = myStack.drop(1)
    (myInt,this)
  }

  /**
    * Returns the state of the virtual machine stack.
    *
    * The value at index 0 is the value on the top of the stack.
    *
    * @return the state of the stack
    */
  override def state: Vector[Int] = {
    myStack
  }
}
