import java.io.File
/*
 过滤的for循环
 */

val filesHere = (new File(".")).listFiles()
for (file <- filesHere if file.getName.endsWith(".scala")) {
  println(file)
  }

