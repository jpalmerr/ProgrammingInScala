// repeated parameters

def echo(args: String*) =
  for (arg <- args) println(arg)

echo("hello")
echo("hello", "world")

val seq = Seq("What's", "up", "doc?")

echo(seq: _*)

// named arguments

def speed(distance: Float, time: Float): Float =
  distance / time

speed(100, 10)
speed(time = 10, distance = 100)

// default parameter values

def defaultArgs(a: Int, b: Int = 1): Int = a + b
defaultArgs(10, 2)
defaultArgs(10)