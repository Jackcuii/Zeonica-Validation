package Mem
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage



class Regfile(Width: Int) extends Module {
  val io = IO(new Bundle {
    val wAddr = Input(UInt(Width.W))
    val wData = Input(UInt(Width.W))
    val wEn = Input(Bool())
    val rAddrA = Input(UInt(Width.W))
    val rAddrB = Input(UInt(Width.W))
    val rAddrC = Input(UInt(Width.W))
    val rDataA = Output(UInt(Width.W))
    val rDataB = Output(UInt(Width.W))
    val rDataC = Output(UInt(Width.W))

    val debug = new DebugFlowWithState(Width)
  })

  // it is better to use blackbox here
}

object rf extends App {
  ChiselStage.emitSystemVerilogFile(
    new Regfile(),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}