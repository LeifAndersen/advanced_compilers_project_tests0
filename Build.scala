import sbt._
import Keys._
import java.io._

object Builder extends Build {
  val Mklauncher = config("mklauncher") extend(Compile)
  val mklauncher = TaskKey[Unit]("mklauncher")
  val mklauncherTask = mklauncher <<= (target, fullClasspath in Runtime) map { (target, cp) =>
    def writeFile(file: java.io.File, str: String) {
      val writer = new PrintWriter(file)
      writer.println(str)
      writer.close()
    }
    val cpString = cp.map(_.data).mkString(":")
    val launchString = """
CLASSPATH="%s"
scala -usejavacp -Djava.class.path="${CLASSPATH}" "$@"
""".format(cpString)
    val targetFile = (target / "scala-sbt").asFile
    writeFile(targetFile, launchString)
    targetFile.setExecutable(true)
  }
  lazy val root = Project(id = "lambda-cal",
                          base = file("."),
                          settings = Project.defaultSettings ++ Seq(mklauncherTask))
}
