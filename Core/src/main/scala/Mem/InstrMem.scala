package Mem
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage

class memIP(Width:Int) extends BlackBox with HasBlackBoxResource {
    // use Vivado IP core
}

class InstrMem(Width: Int) extends Module {
  val io = IO(new Bundle {
    val addr = Input(UInt(Width.W))
    val dataOut = Output(UInt(Width.W))

    val debug = new DebugFlowWithoutState() // No need to mirror out 
  })
  // use Vivado IP core
}
