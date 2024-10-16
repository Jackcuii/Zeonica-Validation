package Std

import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage


class DebugFlowWithState(Width: Int) extends Bundle {
  val mirrorIter = Input(UInt(Width.W))
  val mirrorData = Output(UInt(32.W))
  val halt = Input(Bool())
  val req = Output(Bool())
}

class DebugFlowWithoutState extends Bundle {
  val halt = Input(Bool())
  val req = Output(Bool())
}

class DebugOnlyReq extends Bundle {
  val req = Output(Bool())
}

class Neighbour extends Bundle {
  val south = Bool()
  val east = Bool()
  val west = Bool()
  val north = Bool() 
}

class CommData(width: Int) extends Bundle {
  val data = UInt(width.W)
  val color = UInt(2.W)
}

class NeighbourData(width: Int) extends Bundle {
  val south = CommData(width)
  val east = CommData(width)
  val west = CommData(width)
  val north = CommData(width)
}