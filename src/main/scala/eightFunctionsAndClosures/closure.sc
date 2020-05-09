val more = 1

val addMore = (x: Int) => x + more // closure

addMore(1)

def makeIncreaser(more: Int): Int => Int = (x: Int) => x + more
// Each time this function is called it will create a new closure
val a = makeIncreaser(more)
a(10)