import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

import basicCompo._

// write a testbench for counter_en_cout




class BasicTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of("counter_en_cout")
  it should "basic test" in {
    test(new counterWrapper) { c =>
      c.io.en.poke(true.B)
      c.reset.poke(true.B)
      c.clock.step(1)
      for (i <- 0 until 6) {
        c.io.en.poke(true.B)
        c.reset.poke(false.B)
        c.clock.step(1)
        c.io.Q.expect((i+1).U)
      }
      c.io.en.poke(true.B)
      c.reset.poke(true.B)
      c.clock.step(1)
      c.io.Q.expect(0.U)
    }
  }
}
