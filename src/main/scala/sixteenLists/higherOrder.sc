List(1, 2, 3) map (_ + 1)

val words = List("the", "quick", "brown", "fox")
words map (_.length)

// The flatMap operator is similar to map, but it takes a function returning a list of elements as its right operand.

words map (_.toList)
words flatMap (_.toList)

List.range(1, 5) flatMap (
  i => List.range(1, i) map (j => (i, j))
  )

// Filtering list

List(1, 2, 3, 4, 5) filter (_ % 2 == 0)
words filter (_.length == 3)
List(1, 2, 3, 4, 5) partition (_ % 2 == 0)
List(1,2,3,4,5) find (_%2==0)

// fold

def foldSum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)
def sum(xs: List[Int]): Int = xs.sum

// List().foldLeft(startvalue)(operation) equals (by the definition of foldLeft)


