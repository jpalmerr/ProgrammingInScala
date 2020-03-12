package sixFunctionalObjects

class Rational(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) // auxiliary constructor

  override def toString = s"$numer/$denom"

  def + (that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }
  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)


  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)
  def * (i: Int): Rational =
    new Rational(numer * i, denom)


  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)
  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  def lessThan(that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational): Rational =
    if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object Main extends App {

  implicit def intToRational(x: Int) = new Rational(x)

  val half = new Rational(1, 2) // Rational = 1/2

  val quarter = new Rational(1, 4) // Rational 1/4

  val five = new Rational(5) // Rational = 5/1

  val elevenSevenths = new Rational(66, 42)

  println("half + quarter")
  println(half + quarter)
  println()

  println("half * quarter")
  println(half * quarter)
  println()

  println("half + quarter * quarter")
  println(half + quarter * quarter) // works given Scala’s rules for operator precedence
  println()

  val twoThirds = new Rational(2,3) // Rational = 2/3

  println("twoThirds * 2")
  println(twoThirds * 2)

  println("2 * twoThirds")
  println(2 * twoThirds) // won't compile without the implicit def
}

/*
when you say n or d in add’s implementation,
the compiler is happy to provide you with the values for these class parameters.

But it won’t let you say that.n or that.d because that does not refer to the
Rational object on which add was invoked

To access the numerator and denominator on that, you’ll need to make them into fields.
 */

/*
Auxillary Constructors

Sometimes you need multiple constructors in a class.
In Scala, constructors other than the primary constructor are called auxiliary constructors.

For example, a rational number with a denominator of 1 can be written more succinctly as simply the numerator.
Instead of new Rational(5) , for example, you can just write new Rational(5)

Every auxiliary constructor must invoke another constructor of the same class as its first action.
 */

/*
Method overloading

 With the latest changes, you can now do addition and multiplication operations in a natural style on rational numbers.
 But one thing still missing is mixed arithmetic.
 For instance, you cannot multiply a rational number by an integer because the operands of * always have to be Rationals.
 So for a rational number r you can’t write r * 2.
 You must write r * new Rational(2), which is not as nice.
*/

/*
Implicit Conversions

Now that you can write r * 2,
you might also want to swap the operands, as in 2 * r.
 */
