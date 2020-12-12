package twentyOneImplicit

object Mocha extends App {

  case class PreferredDrink(preference: String)

  implicit val pref = PreferredDrink("mocha")

  def enjoy(name: String)(implicit drink: PreferredDrink): Unit = {
    print("Welcome, " + name)
    print(". Enjoy a ")
    print(drink.preference)
    println("!")
  }
  enjoy("James") // implicit pref
}
