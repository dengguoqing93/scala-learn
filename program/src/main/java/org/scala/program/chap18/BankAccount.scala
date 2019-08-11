package org.scala.program.chap18

/**
  * 账户
  *
  * @author dengguoqing
  * @since 2019/8/3
  */
class BankAccount {

  private var bal = 0

  def balance = bal

  def deposit(amount: Int) = {
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int) = {
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
  }

}
