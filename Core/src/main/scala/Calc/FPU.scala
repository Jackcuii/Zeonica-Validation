package Calc
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage



object FPUop extends ChiselEnum {
    //reserved for future use
}

class FPUIP extends BlackBox with HasBlackBoxResource {
  
}

class FPU(Width: Int) extends RawModule {
  val io = IO(new Bundle {
    val A = Input(UInt(Width.W))
    val B = Input(UInt(Width.W))
    val C = Input(UInt(Width.W))
    val FPURes = Output(UInt(Width.W))
    val FPUop = Input(FPUop())// Reserved for future use
  })

  //could use Berkeley's work
}

object FPU extends App {
  ChiselStage.emitSystemVerilogFile(
    new FPU,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}