/// insertion list sort algorithm

def insert(x: Int, xs: List[Int]): List[Int] =
  if (xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert(x, xs.tail)
def isort(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else insert(xs.head, isort(xs.tail))

isort(List(1, 23, 12, 49, 2)) // List[Int] = List(1, 2, 12, 23, 49)


// List patterns correspond one-by-one to list expressions

val fruit = List("apples", "oranges", "pears")
val fruits = List("apples", "oranges", "pears", "strawberries")

val List(a, b, c) = fruit
a

val x :: y :: rest = fruits
rest

def insertPM(x: Int, xs: List[Int]): List[Int] = xs match {
  case List()  => List(x)
  case y :: ys => if (x <= y) x :: xs
  else y :: insert(x, ys)
}
def isortPM(xs: List[Int]): List[Int] = xs match {
  case List()   => List()
  case x :: xs1 => insert(x, isort(xs1))
}

isortPM(List(1, 23, 12, 49, 2))

// A method is first-order if it does not take any functions as arguments.

List(1, 2) ::: List(3, 4, 5)
// using pm

def append[T](xs: List[T], ys: List[T]): List[T] =
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

append(List(1, 2), List(3, 4, 5)) // List(1, 2, 3, 4, 5)

// init returns a list consisting of all elements except the last one
List(1, 2, 3, 4, 5).init

// reverse

val abcde = List("a", "b", "c", "d", "e")
abcde.reverse

// using pm

def rev[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case ::(head, next) => rev(next) ::: List(head)
}

rev(abcde)

// prefixes and suffixes

abcde take 2 // List(a, b)
abcde drop 2 // List(c, d, e)
abcde splitAt 2 // (List(a, b),List(c, d, e))

// element selection - both RARE

abcde apply 2 // String = c
abcde(2) // String = c

abcde.indices

// flatten

List(List(1, 2), List(3), List(), List(4, 5)).flatten

fruit.flatMap(_.toCharArray)

// The zip operation takes two lists and forms a list of pairs

abcde.indices zip abcde // Vector((0,a), (1,b), (2,c), (3,d), (4,e))
// zip with index does it for you :)
abcde.zipWithIndex

abcde.zipWithIndex.unzip
// (List(a, b, c, d, e),List(0, 1, 2, 3, 4))

// String

abcde.mkString("[", ",", "]") // [a,b,c,d,e]
abcde.mkString("List(", ", ", ")") // List(a, b, c, d, e)