val assertionsEnabled = false

def byNameAssert(predicate: => Boolean) =
if (assertionsEnabled && !predicate)
    throw new AssertionError

val x = 5

byNameAssert(x / 0 == 0)