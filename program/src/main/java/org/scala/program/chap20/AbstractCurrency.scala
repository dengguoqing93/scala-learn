package org.scala.program.chap20

/**
  * 货币类型抽象
  *
  * @author dengguoqing
  * @since 2019/8/4
  */
abstract class AbstractCurrency {
  type Currency <: AbstractCurrency
  val amount: Long

  def designation: String

  override def toString: String = amount + " " + designation

  def +(that: AbstractCurrency): Currency

  def *(x: Double): Currency
}
