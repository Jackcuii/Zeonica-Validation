package Clk

import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage



class dividerIP extends BlackBox with HasBlackBoxResource {
  // Vivado IP is better
}

class freqDivider(originFreq: Int, targetFreq: Int) extends Module {
  val io = IO(new Bundle {
    val clk_out = Output(Clock())
  })
  withReset(false.B) {
    val cntReg = RegInit(0.U(32.W))
    val target = (originFreq/targetFreq)/2
    val toggle = RegInit(false.B)
    cntReg := Mux(cntReg === (target - 1).U, 0.U, cntReg + 1.U)
    toggle := Mux(cntReg === (target - 1).U, ~toggle, toggle)
    io.clk_out := toggle.asClock
  }
}

/**
 * Generate Verilog sources and save it in file GCD.v
 */
object freq extends App {
  ChiselStage.emitSystemVerilogFile(
    new freqDivider(100000000, 1),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}


