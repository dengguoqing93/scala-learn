package org.scala.program.chap15

/**
  * 样例类
  *
  * @author dengguoqing
  * @since 2019/7/30
  */
abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr {
  def main(args: Array[String]): Unit = {
    val expr = simplifyTop(UnOp("-", UnOp("-", Var("x"))))
    println(expr)
  }

  def simplifyTop(expr: Expr): Expr = {
    expr match {
      case UnOp("-", UnOp("-", e))  => e
      case BinOp("+", e, Number(0)) => e
      case BinOp("*", e, Number(1)) => e
      case _                        => expr
    }
  }
}
