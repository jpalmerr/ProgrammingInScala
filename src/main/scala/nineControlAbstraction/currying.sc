def plainOldSum(x: Int, y: Int): Int = x + y
plainOldSum(1, 2)

def curriedSum(x: Int)(y: Int): Int = x + y
curriedSum(1)(2)

val onePlus = curriedSum(1)_
onePlus(2)

def twice(op: Double => Double, x: Double) = op(op(x))

twice(_ * 2, 2)




