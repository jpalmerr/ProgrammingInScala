case class PreferredPrompt(preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt): Unit = {
    println("Welcome, " + name + ". The system is ready.")
    println(prompt.preference)
  }
}

// can still pass explicitly
val bobsPrompt = PreferredPrompt("relax.")
Greeter.greet("James")(bobsPrompt)

/*
To let the compiler supply the parameter implicitly,
you must first define a variable of the expected type,
which in this case is PreferredPrompt.
*/

object JamesPrompt {
  implicit val jamesPrompt: PreferredPrompt = PreferredPrompt("Yes sir")
}

import JamesPrompt._
Greeter.greet("James")
// Welcome, James. The system is ready. Yes sir