package Calc
import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage

object ALUop extends ChiselEnum {
    val ADD, SUB, NOT, AND, OR, XOR, GTS, EQU = Value
}

class ALU(Width: Int) extends RawModule {
  val io = IO(new Bundle {
    val A = Input(UInt(Width.W))
    val B = Input(UInt(Width.W))
    val ALUop = Input(ALUop())
    val ALURes = Output(UInt(Width.W))
  })

}

object ALU extends App {
  ChiselStage.emitSystemVerilogFile(
    new ALU,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}