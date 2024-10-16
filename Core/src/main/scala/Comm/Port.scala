package STD

import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage
import basicCompo._
import CLK._
import chisel3.util.HasBlackBoxResource
import upickle.implicits.key


/*

class CommPort(portWidth: Int = 1, granularity: Int) extends Module {
  val io = IO(new Bundle {
    val clk = Input(Clock())
    val rst = Input(Bool())
    val dataIn = Input(UInt((portWidth * granularity).W))
    val dataOut = Output(UInt((portWidth * granularity).W))
    val colorIn = Input(UInt((2.W)))
    val colorOut = Output(UInt((2.W)))
    val reqIn = Input(Bool()) // there is a transfer request
    val nextIn = Input(Bool()) // Open to next transfer
    val reqOut = Output(Bool())
    val nextOut = Output(Bool())
  })
  val buffer = RegInit(0.U((portWidth * granularity).W)) // really need?
  reqOut := reqIn
  nextOut := nextIn
  io.dataOut := buffer
  buffer := io.dataIn
}

object dataType(width: Int) extends Bundle {
  val data = UInt(width.W)
  val color = UInt(2.W)
}

class recvBuf(portWidth: Int = 1, unitSum: Int, granularity: Int) extends Module {
  // **unitSum must be divisible by portWidth
  val io = IO(new Bundle {
    val clk = Input(Clock())
    val rst = Input(Bool())
    val dataIn = Input(Vec(portWidth, dataType(granularity)))
    val dataOut = Output(Vec(portWidth, dataType(granularity)))
    val wreq = Input(Bool())  // from the port
    val next = Output(Bool())  // to the port
    val fetch = Input(Bool())  // from the core
  })
  val buffer = Mem(unitSum, dataType(granularity))
  val addrWidth = log2Ceil(unitSum) + 1
  val readPtr = RegInit(0.U(addrWidth.W))
  val writePtr = RegInit(0.U(addrWidth.W))
  val nextReg = RegInit(true.B) // when reset should okay.

  def nextAdder(in) = {
    Mux((in + 1.U)(addrWidth), 0.U(addrWidth), (in + 1.U)(addrWidth))
  }

  io.next := nextReg
  nextReg := Mux(nextReg
    Mux((nextAdder(writePtr) === readPtr) && (~io.fetch || io.wreq), false.B, nextReg)
    Mux((writeAddr === readPtr) && io.fetch && ~io.req, true.B, nextReg) // actually must be equal
  )
  for (i <- 0 until portWidth) {
    io.dataOut(i) := buffer(readPtr + i.U)
  }
  writePtr := Mux(io.wreq, nextAdder(writePtr), writePtr)
  buffer(writePtr) := Mux(io.wreq, io.dataIn, buffer(writePtr)) // will this cause a latch? must check it!
  readPtr := Mux(io.fetch, nextAdder(readPtr), readPtr)
  // could read and write at the same time, but must check if the compiled is async
}

class sendBuf(portWidth: Int = 1, unitSum: Int, granularity: Int) extends Module {
  // **unitSum must be divisible by portWidth
  val io = IO(new Bundle {
    val clk = Input(Clock())
    val rst = Input(Bool())
    val dataIn = Input(Vec(portWidth, dataType(granularity)))
    val dataOut = Output(Vec(portWidth, dataType(granularity)))
    val wreq = Output(Bool())  // from the port
    val next = Input(Bool())  // to the port
    val fetch = Input(Bool())  // from the core
  })
  val buffer = Mem(unitSum, dataType(granularity))
  val addrWidth = log2Ceil(unitSum) + 1
  val readPtr = RegInit(0.U(addrWidth.W))
  val writePtr = RegInit(0.U(addrWidth.W))
  val nextReg = RegInit(true.B) // when reset should okay.

  def nextAdder(in) = {
    Mux((in + 1.U)(addrWidth), 0.U(addrWidth), (i + 1.U)(addrWidth))
  }

  io.next := nextReg
  nextReg := Mux(nextReg
    Mux((nextAdder(writePtr) === readPtr) && (~io.fetch || io.wreq), false.B, nextReg)
    Mux((writeAddr === readPtr) && io.fetch && ~io.req, true.B, nextReg) // actually must be equal
  )
  for (i <- 0 until portWidth) {
    io.dataOut(i) := buffer(readPtr + i.U)
  }
  writePtr := Mux(io.wreq, nextAdder(writePtr), writePtr)
  buffer(writePtr) := Mux(io.wreq, io.dataIn, buffer(writePtr)) // will this cause a latch? must check it!
  readPtr := Mux(io.fetch, nextAdder(readPtr), readPtr)
  // could read and write at the same time, but must check if the compiled is async
}



object keyboardDriver extends App {
  ChiselStage.emitSystemVerilogFile(
    new keyboard,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

*/