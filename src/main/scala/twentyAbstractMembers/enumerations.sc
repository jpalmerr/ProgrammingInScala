object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}

object Direction extends Enumeration {
  val North, East, South, West = Value
}

object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}

for (d <- Direction.values) print(d + " ")

Direction.East.id // 1