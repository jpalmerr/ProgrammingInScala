// requiring the type of the list to mix in

case class Person(firstName: String, lastName: String)
  extends Ordered[Person] {
  def compare(that: Person) = {
    val lastNameComparison =
      lastName.compareToIgnoreCase(that.lastName)
    if (lastNameComparison != 0)
      lastNameComparison
    else
      firstName.compareToIgnoreCase(that.firstName)
  }
  override def toString = firstName + " " + lastName
}


def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(orderedMergeSort(ys), orderedMergeSort(zs))
  }
}

/**
To require that the type of the list passed to your new sort function mixes in Ordered, you need to use an upper bound.
 */

val people: List[Person] = List(
           Person("Larry", "Wall"),
           Person("Anders", "Hejlsberg"),
           Person("Guido", "van Rossum"),
           Person("Alan", "Kay"),
           Person("Yukihiro", "Matsumoto")
)

val sortedPeople = orderedMergeSort(people)