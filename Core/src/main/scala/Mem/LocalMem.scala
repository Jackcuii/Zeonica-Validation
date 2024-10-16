package Mem
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage



object Memop extends ChiselEnum {
    val LOAD, STORE = Value
}

class memIP(Width:Int) extends BlackBox with HasBlackBoxResource {

}

class LocalMem(Width: Int) extends RawModule {
  val io = IO(new Bundle {
    val addr = Input(UInt(Width.W))
    val dataIn = Input(UInt(Width.W))
    val dataOut = Output(UInt(Width.W))
    val memOp = Input(Memop())
    val readClk = Input(Clock())
    val writeClk = Input(Clock())

    val debug = new DebugFlowWithState()
  })
  // use Vivado IP core
}

object mem extends App {
  ChiselStage.emitSystemVerilogFile(
    new LocalMem(),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}