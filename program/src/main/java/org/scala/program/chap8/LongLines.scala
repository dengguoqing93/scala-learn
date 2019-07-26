package org.scala.program.chap8
import scala.io.Source

/**
  * 某行的长度
  *
  * @author dengguoqing
  * @since 2019/7/22
  */
object LongLines {

  private def processLine(filename: String, width: Int, line: String) = {
    if (line.length > width) println(filename + ":" + line.trim)
  }

  def processFiles(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }
}
