package org.scala.program.chap6

/**
  * 有理数
  *
  * @author dengguoqing
  * @since 2019/7/21
  */
class Rational(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)

  val number: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  /**
    * 加法
    *
    * @param that
    * @return
    */
  def +(that: Rational) = {
    new Rational(number * that.denom + that.number * denom, denom * that.denom)
  }

  def +(i: Int) = new Rational(number + i * denom, denom)

  def -(that: Rational) = {
    new Rational(number * that.denom - that.number * denom, denom * that.denom)
  }

  /**
    * 有理数减去一个整数
    *
    * @param int 整数减数
    * @return
    */
  def -(int: Int): Rational = {
    new Rational(number - int * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(number * that.number, denom * that.denom)
  }

  def *(int: Int): Rational = {
    new Rational(number * int, denom)
  }

  def /(that: Rational): Rational = {
    new Rational(number * that.denom, that.number * denom)
  }

  def /(int: Int): Rational = {
    new Rational(number, denom * int)
  }

  def add(that: Rational): Rational = {
    new Rational(number * that.denom + that.number * denom, denom * that.denom)
  }

  def lessThan(that: Rational) = {
    this.number * that.denom < that.number * this.denom
  }

  def max(that: Rational) = if (this.lessThan(that)) that else this

  override def toString: String = number + "/" + denom

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
