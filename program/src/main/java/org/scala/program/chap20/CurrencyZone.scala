package org.scala.program.chap20

/**
  * ${DESCRIPTION}
  *
  * @author dengguoqing
  * @since 2019/8/4
  */
abstract class CurrencyZone {
  type Currency <: AbstractCurrency

  def make(x: Long): Currency

  abstract class AbstractCurrency {
    val amount: Long

    def designation: String

    override def toString: String = amount + " " + designation

    def +(that: Currency): Currency = make(this.amount + that.amount)

    def *(x: Double): Currency = make((this.amount * x).toLong)

  }

}

object US extends CurrencyZone {

  abstract class Dollar extends AbstractCurrency {
    override def designation: String = "USD"
  }

  override type Currency = Dollar

  override def make(x: Long): Dollar = new Dollar { val amount = x }

}
