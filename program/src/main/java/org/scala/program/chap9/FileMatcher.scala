package org.scala.program.chap9
import java.io.File

/**
  * 文件匹配器
  *
  * @author dengguoqing
  * @since 2019/7/23
  */
object FileMatcher {

  private def filesHere = new File(".").listFiles()

  private def filesMatching(matcher: String => Boolean) = {
    for {
      file <- filesHere
      if matcher(file.getName)
    } yield file
  }

  def filesEnding(query: String) = {
    filesMatching(_.endsWith(query))
  }

  def fileContaining(query: String) = {
    filesMatching(_.contains(query))
  }
  def filesRegex(query: String) = {
    filesMatching(_.matches(query))
  }
}
