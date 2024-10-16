package Ctrl
import Mem._
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage



class RegularCtrl extends RawModule {
  val io = IO(new Bundle {
    val instr = Input(UInt(32.W))
    val triggerRegi = Output(Bool())
    val memOp = Output(MemOp())
    val ALUSrcB = Output(ALUSrcBsel())
    val resSel = Output(Bool())
    val regWr = Output(Bool())

    val debug = new DebugOnlyReq()
  })


}

object rc extends App {
  ChiselStage.emitSystemVerilogFile(
    new RegularCtrl,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}