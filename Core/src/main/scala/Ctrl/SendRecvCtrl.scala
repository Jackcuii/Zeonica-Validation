package Ctrl
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage



class SendRecvCtrl extends RawModule {
  val io = IO(new Bundle {
    val instr = Input(UInt(32.W))
    val jmp = Output(Bool())
    val dataIn = Output(UInt(32.W)) // from regfile
    val recvReady = Input(Neighbour())
    val sendReady = Output(Neighbour())
    val sendNext = Input(Neighbour())
    val recvNext = Output(Neighbour())
    val stall = Output(Bool())

    val debug = new DebugOnlyReq()
  })

}

object src extends App {
  ChiselStage.emitSystemVerilogFile(
    new SendRecvCtrl,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}