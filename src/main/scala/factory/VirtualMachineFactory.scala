package factory

import bc.{ByteCodeFactory,ByteCodeFactoryImpl,ByteCodeParser,ByteCodeParserImpl}
import vendor.{ProgramParser, ProgramParserImpl}
import vm.{VirtualMachine, VirtualMachineImpl, VirtualMachineParser, VirtualMachineParserImpl}

/**
  * The [[VirtualMachineFactory]] follows the *factory pattern*.
  * It provides methods which create and return instantiations of the
  * required class
  */
object VirtualMachineFactory {
  /**
    * Returns an instantiation of ByteCodeFactoryImpl
    *
    * @return ByteCodeFactoryImpl
    */
  def byteCodeFactory: ByteCodeFactory = new ByteCodeFactoryImpl()

  /**
    * Returns an instantiation of ProgramParserImpl
    *
    * @return ProgramParserImpl
    */
  def vendorParser: ProgramParser = new ProgramParserImpl()

  /**
    * Returns an instantiation of ByteCodeParserImpl
    *
    * @return ByteCodeParserImpl
    */
  def byteCodeParser: ByteCodeParser = new ByteCodeParserImpl()

  /**
    * Returns an instantiation of VirtualMachineParserImpl
    *
    * @return VirtualMachineParserImpl
    */
  def virtualMachineParser: VirtualMachineParser =  new VirtualMachineParserImpl()

  /**
    * Returns an instantiation of VirtualMachineImpl
    *
    * @return VirtualMachineImpl
    */
  def virtualMachine: VirtualMachine = new VirtualMachineImpl()

}
