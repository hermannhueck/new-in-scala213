package object util {

  def prtTitle(
      text: String,
      width: Int = 80,
      leading: String = "",
      trailing: String = "",
      fill: String = "\u2500"
  ): Unit =
    println(title(text, width, leading, trailing, fill))

  def title(
      text: String,
      width: Int = 80,
      leading: String = "",
      trailing: String = "",
      fill: String = "\u2500"
  ): String = {
    s"${line(width, leading, "", fill)}${subTitle(text.toUpperCase, width, "\n", s"$trailing\n", fill)}"
  }

  def prtSubTitle(
      text: String,
      width: Int = 80,
      leading: String = "",
      trailing: String = "",
      fill: String = "\u2500"
  ): Unit =
    println(subTitle(text, width, leading, trailing, fill))

  def subTitle(
      text: String,
      width: Int = 80,
      leading: String = "",
      trailing: String = "",
      fill: String = "\u2500"
  ): String = {
    val frontPad    = fill * 10
    val startLength = (10 + text.length() + 2)
    val endLength   = if (startLength > width) 0 else width - startLength
    val endPad      = fill * endLength
    s"$leading$frontPad $text $endPad$trailing"
  }

  def prtLine(
      width: Int = 80,
      leading: String = "",
      trailing: String = "",
      fill: String = "\u2500"
  ): Unit =
    println(line(width, leading, trailing, fill))

  def line(
      width: Int = 80,
      leading: String = "",
      trailing: String = "",
      fill: String = "\u2500"
  ): String = {
    val line = fill * width
    s"$leading$line$trailing"
  }
}
