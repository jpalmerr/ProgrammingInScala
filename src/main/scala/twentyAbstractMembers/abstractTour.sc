trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String

  def transform(x: String): String = x + x

  val initial = "hi"
  var current = initial
}

abstract class Fruit {
  val v: String // ‘v' for value
  def m: String // ‘m' for method
}
abstract class Apple extends Fruit {
  val v: String
  val m: String // OK to override a ‘def' with a ‘val'
}
/*
abstract class BadApple extends Fruit {
  def v: String // ERROR: cannot override a ‘val' with a ‘def'
  def m: String
}
*/

class Rational(n: Int, d: Int)
new Rational(1, 2)
/*
are evaluated before class Rational is initialized,
so the values of expr1 and expr2 are available for the initialization of class Rational.

For traits, the situation is the opposite
 */

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
}

new RationalTrait {
  val numerArg = 1
  val denomArg = 2
}

/*
exprs are evaluated as part of the initialization of the anonymous class,
but the anonymous class is initialized after the RationalTrait.

So the values of numerArg and denomArg are not available during the initialization of RationalTrait
(more precisely, a selection of either value would yield the default value for type Int, 0).

If you try to instantiate this trait with some numerator and denominator expressions that are not simple literals,
(e.g. val x = 2 val numerArg = 2 * x)
you’ll get an exception
 */

// pre-initialized fields

val x = 2
new {
  val numerArg = 1 * x
  val denomArg = 2 * x
} with RationalTrait

object twoThirds extends {
  val numerArg = 2
  val denomArg = 3
} with RationalTrait

// Lazy vals

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = s"$numer/$denom"
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

new LazyRationalTrait {
  val numerArg = 1 * x
  val denomArg = 2 * x
}