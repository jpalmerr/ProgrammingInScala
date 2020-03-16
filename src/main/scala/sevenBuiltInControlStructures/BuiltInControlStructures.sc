// IF

val boolean = true

if (boolean) println("hello")
else println("goodbye")

// WHILE

def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a= b % a
    b = temp
  }
  b }

gcdLoop(10, 8) // 2

/*
Because the while loop results in no value,
it is often left out of pure functional languages.

In general, we recommend you challenge while loops in your code
in the same way you challenge vars.
In fact, while loops and vars often go hand in hand.

Because while loops don’t result in a value, to make any kind of difference to your program,
a while loop will usually either need to update vars or perform I/O.
*/

// Preferred solution
def gcd(x: Long, y: Long): Long =
  if (y == 0) x else gcd(y, x % y)

gcd(10, 8)

// FOR

// expression not comprehension...

for (i <- 1 to 4)
  println("Iteration " + i)

/*
If you don’t want to include the upper bound of the range in the values that are iterated over,
use until instead of to:
 */

for (i <- 1 until 4)
  println("Iteration " + i)

// FILTERING

val filesHere = (new java.io.File(".")).listFiles
for (file <- filesHere if file.getName.endsWith(".scala"))
  println(file)

// You can include more filters if you want. Just keep adding if clauses.

for (
  file <- filesHere
  if file.isFile
  if file.getName.endsWith(".scala")
) println(file)