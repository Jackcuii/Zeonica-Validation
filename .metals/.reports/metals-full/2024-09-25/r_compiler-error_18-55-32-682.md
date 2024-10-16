file://<WORKSPACE>/Core/src/main/scala/Part/Keyboard.scala
### java.lang.OutOfMemoryError: Java heap space: failed reallocation of scalar replaced objects

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 411
uri: file://<WORKSPACE>/Core/src/main/scala/Part/Keyboard.scala
text:
```scala
package STD

import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._
import _root_.circt.stage.ChiselStage
import basicCompo._
import CLK._
import chisel3.util.HasBlackBoxResource
import upickle.implicits.key

object KeyboardState extends ChiselEnum {
    val READY, HOLD, HALFR, WRONG = Value
}

class scancode_ram extends BlackBox with HasBlackBoxResource {
  』@@

object keyboardDriver extends App {
  ChiselStage.emitSystemVerilogFile(
    new keyboard,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}
```



#### Error stacktrace:

```

```
#### Short summary: 

java.lang.OutOfMemoryError: Java heap space: failed reallocation of scalar replaced objects