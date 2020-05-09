/*
The most common way to define a function is as a member of some object; such a function is called a method.
 */

import scala.io.Source

def processLine(filename: String,
                        width: Int, line: String) = {
  if (line.length > width)
    println(filename + ": " + line.trim)
}
def processFile(filename: String, width: Int) = {
  val source = Source.fromFile(filename)
  for (line <- source.getLines())
    processLine(filename, width, line)
}