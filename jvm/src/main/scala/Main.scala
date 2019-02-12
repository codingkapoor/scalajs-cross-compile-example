import com.glassbeam.scalar.common.spl.compiler.SplCompiler
import com.glassbeam.scalar.common.spl.types._
import shapeless.tag

object Main {
  val manufacturer = tag[ManufacturerT]("summit")
  val product = tag[ProductT]("summit")
  val schema = tag[SchemaT]("pod60")

  val mps: MPS = (manufacturer, product, schema)

  def main(args: Array[String]): Unit = {
    val c = new SplCompiler(mps, "/home/shivam/Desktop/summit/pod")
    c.getAST()
    val lib = new MyLibrary
    println(lib.sq(2))
  }
}
