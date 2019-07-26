package org.scala.program.chap10

import Element.elem

/**
  * 布局元素抽象类
  *
  * @author dengguoqing
  * @since 2019/7/26
  */
abstract class Element {

  /**
    * 元素内容
    *
    * @return
    */
  val contents: Array[String]

  /**
    * 布局元素的高度
    *
    * @return
    */
  def height: Int = {
    contents.length
  }

  /**
    * 布局元素的宽度
    *
    * @return
    */
  def width: Int = {
    if (height == 0) 0 else contents(0).length
  }

  def demo(): Unit = println("Element's implementation invoked")

  /**
    * 将某个元素放在另一个元素的上面
    *
    * @param that 另一个元素
    * @return
    */
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  /**
    * 将两个元素并排放在一起
    *
    * @param that 另外一个元素
    * @return
    */
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents) yield {
        line1 + line2
      }
    )
  }

  def widen(int: Int): Element = {
    if (int <= width) this
    else {
      val left = elem(' ', (int - width) / 2, height)
      val right = elem(' ', int - width - left.width, height)
      left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }

  override def toString: String = contents mkString "\n"
}

object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = {
    new UniformElement(chr, width, height)
  }

  def elem(s: String): Element = new LineElement(s)

  private class UniformElement(ch: Char,
                               override val width: Int,
                               override val height: Int)
      extends Element {
    private val line = ch.toString * width

    val contents: Array[String] = Array.fill(height)(line)
  }

  /**
    * 数组类布局元素
    *
    * @author dengguoqing
    * @since 2019/7/26
    */
  private class ArrayElement(val conts: Array[String]) extends Element {

    /**
      * 元素内容
      *
      * @return
      */
    val contents: Array[String] = conts

    override def demo(): Unit = println("ArrayElement's implementation invoked")
  }

  /**
    * 行布局元素
    *
    * @author dengguoqing
    * @since 2019/7/26
    */
  private class LineElement(s: String) extends Element {

    /**
      * 元素内容
      *
      * @return
      */
    override val contents: Array[String] = Array(s)

    /**
      * 布局元素的高度
      *
      * @return
      */
    override def height: Int = {
      1
    }

    /**
      * 布局元素的宽度
      *
      * @return
      */
    override def width: Int = {
      s.length
    }

    override def demo(): Unit = println("LineElement's implementation invoked")
  }

}
