implicit def doubleToInt(x: Double) = x.toInt

val i: Int = 3.5 // now double can pass as int

case class Rational(n: Int, d: Int) {


  def + (fraction: Rational): Rational =
    Rational(
      n * fraction.n + fraction.n * d,
      n * fraction.d
    )

  def + (i: Int): Rational =
    Rational(n + i * d, d)
}

val oneHalf: Rational = Rational(1, 2)
oneHalf + oneHalf

/**
 * What about an expression like 1 + oneHalf?
 * This expression is tricky because the receiver, 1, does not have a suitable + method.
 * So the following gives an error
 *
 * 1 + oneHalf
 *
 * To allow this kind of mixed arithmetic, you need to define an implicit conversion from Int to Rational
 */

implicit def intToRational(x: Int) = Rational(x, 1)

1 + oneHalf // now its possible
