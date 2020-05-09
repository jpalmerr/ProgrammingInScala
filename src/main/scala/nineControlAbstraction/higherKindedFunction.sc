object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles
  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}


def containsNeg(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num < 0)
      exists = true
  exists
}

containsNeg(List(1, 2, 3, 4)) // Boolean = false
containsNeg(List(1, 2, 3, -4)) // Boolean = true

// using higher kinded function (exists)

def containsNegative(nums: List[Int]): Boolean = nums.exists(_ < 0)

containsNeg(List(1, 2, 3, 4))

def containsOdd(nums: List[Int]): Boolean = nums.exists(_ % 2 == 1)
containsOdd(List(1, 2, 3, 4))
