import fifteenCaseClasses.model._

/*
A sealed class cannot have any new subclasses added except the ones in the same file.
This is very useful for pattern matching because it means you only need
to worry about the subclasses you already know about.

You get better compiler support as well.
If you match against case classes that inherit from a sealed class,
the compiler will flag missing combinations of patterns with a warning message.
 */
def describe(e: Expr): String = e match { // exhaustive compiler support
  case Var(_) => "a variable"
  case Number(_) => "a number"
  case UnOp(_, _) => "UnOp"
  case BinOp(_, _, _) => "binOP"
}

def describe(e: Expr): String = (e: @unchecked) match {
  case Number(_) => "a number"
  case Var(_)    => "a variable"
}

/*
If a match’s selector expression carries this annotation, exhaustivity checking for the patterns that follow will be suppressed.

^not something I ever particularly envisage using
 */

val myTuple = (123, "abc")
val (number, string) = myTuple
number // 123

val exp = new BinOp("*", Number(5), Number(1))
val BinOp(op, left, right) = exp

/*
Partial functions have a method isDefinedAt,
which can be used to test whether the function is defined at a particular value
 */

val second: PartialFunction[List[Int],Int] = {
  case x :: y :: _ => y
}

second.isDefinedAt(List(5,6,7))
second.isDefinedAt(List(1))