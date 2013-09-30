object Main {
  def compile = Compile.apply _ compose Exp.from _ compose SExp.from _

  def main(args: Array[String]) {
    var prog = ""
    for(ln <- io.Source.stdin.getLines) {
      prog += ln
    }
    val res = compile(prog)
    println(res)
  }
}
