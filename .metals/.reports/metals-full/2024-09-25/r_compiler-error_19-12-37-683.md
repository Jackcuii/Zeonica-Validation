file://<WORKSPACE>/Core/src/main/scala/Part/Keyboard.scala
### java.lang.OutOfMemoryError: Java heap space

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 346
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

】@@

object keyboardDriver extends App {
  ChiselStage.emitSystemVerilogFile(
    new keyboard,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}
```



#### Error stacktrace:

```
scala.meta.internal.tokenizers.ScalametaTokenizer.getInvalid(ScalametaTokenizer.scala:304)
	scala.meta.internal.tokenizers.ScalametaTokenizer.getToken(ScalametaTokenizer.scala:296)
	scala.meta.internal.tokenizers.ScalametaTokenizer.loop$1(ScalametaTokenizer.scala:152)
	scala.meta.internal.tokenizers.ScalametaTokenizer.uncachedTokenize(ScalametaTokenizer.scala:162)
	scala.meta.internal.tokenizers.ScalametaTokenizer.$anonfun$tokenize$1(ScalametaTokenizer.scala:16)
	scala.meta.internal.tokenizers.ScalametaTokenizer$$Lambda$3886/0x000074e5003a7818.apply(Unknown Source)
	scala.collection.concurrent.TrieMap.getOrElseUpdate(TrieMap.scala:962)
	scala.meta.internal.tokenizers.ScalametaTokenizer.tokenize(ScalametaTokenizer.scala:16)
	scala.meta.internal.tokenizers.ScalametaTokenizer$$anon$1.apply(ScalametaTokenizer.scala:313)
	scala.meta.tokenizers.Api$XtensionTokenizeDialectInput.tokenize(Api.scala:22)
	scala.meta.tokenizers.Api$XtensionTokenizeInputLike.tokenize(Api.scala:13)
	scala.meta.internal.mtags.ScalametaCommonEnrichments$XtensionStringDocMeta.safeTokenize(ScalametaCommonEnrichments.scala:237)
	scala.meta.internal.mtags.ScalametaCommonEnrichments$XtensionStringDocMeta.checkIfNotInComment(ScalametaCommonEnrichments.scala:256)
	scala.meta.internal.pc.completions.KeywordsCompletions$.checkIfNotInComment(KeywordsCompletions.scala:92)
	scala.meta.internal.pc.completions.KeywordsCompletions$.notInComment$lzyINIT1$1(KeywordsCompletions.scala:18)
	scala.meta.internal.pc.completions.KeywordsCompletions$.scala$meta$internal$pc$completions$KeywordsCompletions$$$_$notInComment$1(KeywordsCompletions.scala:18)
	scala.meta.internal.pc.completions.KeywordsCompletions$$anon$1.applyOrElse(KeywordsCompletions.scala:23)
	scala.meta.internal.pc.completions.KeywordsCompletions$$anon$1.applyOrElse(KeywordsCompletions.scala:21)
	scala.collection.immutable.List.collect(List.scala:267)
	scala.meta.internal.pc.completions.KeywordsCompletions$.contribute(KeywordsCompletions.scala:24)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:188)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:89)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:155)
```
#### Short summary: 

java.lang.OutOfMemoryError: Java heap space