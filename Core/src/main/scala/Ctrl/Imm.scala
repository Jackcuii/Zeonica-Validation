package Ctrl
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage



class Branch extends RawModule {
  val io = IO(new Bundle {
    val instr = Input(UInt(32.W))
    val imm = Output(UInt())
    
    val debug = new DebugOnlyReq()
  })

}

object imm extends App {
  ChiselStage.emitSystemVerilogFile(
    new imm,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}