/**
Functional queues
A functional queue is a data structure with three operations:

- head returns the first element of the queue
- tail returns a queue without its first element
- enqueue returns a new queue with a given element appended at the end
 */

class QueueClass[T] private(
                private val leading: List[T],
                private val trailing: List[T]
              ) {
  private def mirror: QueueClass[T] =
    if (leading.isEmpty)
      new QueueClass(trailing.reverse, Nil)
    else this

  def head: T = mirror.leading.head

  def tail: QueueClass[T] = {
    val q = mirror
    new QueueClass(q.leading.tail, q.trailing)
  }

  def enqueue(x: T): QueueClass[T] =
    new QueueClass(leading, x :: trailing)
}

object QueueClass {
  def apply[T](leading: List[T], trailing: List[T]): QueueClass[T] = new QueueClass(leading, trailing)
}

val queue: QueueClass[Int] = QueueClass.apply(List(1, 2, 3),List(1, 2, 3))

queue.head
queue.tail
queue.enqueue(10)

/*
The private modifier between the class name
and its parameters indicates that the constructor of Queue is private:
it can be accessed only from within the class itself and its companion object.
 */

// alternative

trait Queue[T] {
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
}
object Queue {
  def apply[T](xs: T*): Queue[T] =
    new QueueImpl[T](xs.toList, Nil)
  private class QueueImpl[T](
                              private val leading: List[T],
                              private val trailing: List[T]
                            ) extends Queue[T] {
    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this
    def head: T = mirror.leading.head
    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }
    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)
  } }


def doesCompile(q: Queue[String])

/**
Thus, Queue is a trait and Queue[String] is a type.
Queue is also called a type constructor because
you can construct a type with it by specifying a type parameter