import fifteenCaseClasses.model._

def matching(expr: Expr, intList: List[Int]): Unit = {

// Constructor patterns

  expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  }

// Sequence patterns

  intList match {
    case List(0, _, _) => println("found it")
    case _ =>
  }

  // If you want to match against a sequence without specifying how long it can be, you can specify _* as the last element of the pattern.

  intList match {
    case List(0, _*) => println("found it")
    case _ =>
  }
}

// Tuple patterns

def tupleDemo(expr: Any): Unit =
  expr match {
    case (a, b, c)  =>  println("matched " + a + b + c)
    case _ => }

// typed pattern

def generalSize(x: Any): Int = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ => -1
}

generalSize("abc")
generalSize(Map(1 -> 'a', 2 -> 'b'))
generalSize(math.Pi)

/*
Type erasure
Can you also test for a map with specific element types?

no information about type arguments is maintained at runtime => no
 */


/*
The only exception to the erasure rule is arrays,
because they are handled specially in Java as well as in Scala.
The element type of an array is stored with the array value, so you can pattern match on it.
 */

def isStringArray(x: Any): String = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}

isStringArray(Array("stringArray"))
isStringArray(Array(1, 2))
isStringArray("nope")

// pattern guard

def simplifyAdd(e: Expr): Expr = e match {
  case BinOp("+", x, y) if x == y =>
    BinOp("*", x, Number(2))
  case _ => e
}

simplifyAdd(BinOp("+", Number(2), Number(2)))