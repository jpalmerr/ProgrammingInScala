The use of tail recursion in Scala is fairly limited because the JVM instruction set
makes implementing more advanced forms of tail recursion very difficult.

Scala only optimizes directly recursive calls back to the same function making the call.
If the recursion is indirect, as in the following example of two mutually recursive functions,
no optimization is possible.

```scala
  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)
  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1)
```

You also won’t get a tail-call optimization if the final call goes to a function value.

```scala
val funValue = nestedFun _
  def nestedFun(x: Int) : Unit = {
    if (x != 0) { println(x); funValue(x - 1) }
  }
```

Tail-call optimization is limited to situations where a method or nested function
calls itself directly as its last operation,
without going through a function value or some other intermediary.