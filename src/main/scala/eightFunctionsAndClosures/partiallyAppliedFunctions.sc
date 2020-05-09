/*
A partially applied function is an expression in which you don’t supply all
of the arguments needed by the function.
Instead, you supply some, or none, of the needed arguments.
 */

def sum(a: Int, b: Int, c: Int): Int = a + b + c

sum(1, 2, 3)

val a = sum _
a(1, 2, 3)

val b = sum(1, _: Int, 3)
b(2) // Int = 6

val c: (Int, Int, Int) => Int = sum
// can use this syntax is type provided ^

