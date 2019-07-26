package org.scala.program.chap4

import org.scala.program.ChecksumAccumulator.calculate

/**
  * 汇总处理
  *
  * @author dengguoqing
  * @since 2019/7/21
  */

object Summer {
  def main(args: Array[String]): Unit = {
    for (elem <- args) {
      println(elem + ":" + calculate(elem))
    }
  }
}
