
import scala.collection.mutable.ListBuffer

class Teacher ( name: String,
                surname: String,
                age: Int,
                address: Address,
                var account: Account,
                var course: Course )
  extends UserHuman(
    name,
    surname,
    age,
    address ){


  private var _account: Account = account
  private var _course: Course = course
  var _student_buflist = ListBuffer[Student]()

  def Account: Account = _account
  def Course: Course = _course

  def Payment(exchange: Exchange): Unit ={
    _account.tokens += _course.cost
  }

  def SaleAndPurchaseOfTokens(exchange: Exchange) {
    print("\n" + this.name + " " + this.surname + ":")
    print("\n" + _account.tokens + " tokens on the account. ")
    println("\n" + _account.cash + " funds on the account. ")
    exchange.ShowCourseInfo()
    var value_cash: Int = _account.cash
    var value_tokens: Int = _account.tokens
    var value_purchase_price_tokens: Double = exchange.Purchase_price_tokens
    var value_selling_price_tokens: Double = exchange.Selling_price_tokens


    //println("--The algorithm will choose to BUY or SELL tokens--")
    var rand_choice: Int = scala.util.Random.between(1, 2)

    rand_choice match {

      case 1 =>
        println("--BUY--")
        println("This teacher can buy " + (value_cash / value_purchase_price_tokens) + " tokens \n Enter the desired quantity of tokens to buy: ")
        var quantity_of_tokens: Int = scala.io.StdIn.readInt()
        if (_account.cash < (quantity_of_tokens * exchange.Purchase_price_tokens).toInt) {
          println("This teacher doesn't have enough funds.")
        }
        else {
          var value_buying_tokens: Int = exchange.BuyingTokens(quantity_of_tokens)
          _account.tokens = _account.tokens + value_buying_tokens
          _account.cash -= (value_buying_tokens * exchange.Purchase_price_tokens).toInt

        }


      case 2 =>
        println("--SELL--")
        println("This teacher can receive " + (value_tokens * value_selling_price_tokens) + " funds \n Enter the quantity of tokens to sell: ")
        var quantity_of_tokens_2: Int = scala.io.StdIn.readInt()
        if (_account.tokens < quantity_of_tokens_2) {
          println("This teacher doesn't have enough tokens.")
        }
        else {
          var value_buying_tokens_2: Int = exchange.BuyingTokens(quantity_of_tokens_2)
          _account.cash = _account.cash + value_buying_tokens_2
          _account.tokens = _account.tokens - (value_buying_tokens_2 * exchange.Purchase_price_tokens).toInt
        }

    }

  }


  def AddStudentToList(student: Student): Unit = {
    _student_buflist += student
  }

  def GiveGrades() {
    for (i <- 0 until _student_buflist.length) {
      var value: Int = scala.util.Random.between(1, 5)
      _student_buflist(i).rate(value)
    }
  }

  def ShowInfoStudent(): Unit = {
    for (i <- 0 until _student_buflist.length) {
      println("\n" + this._student_buflist(i).toString)
    }
  }

  override def toString(): String =
    super.toString +
    "Account: " + account.toString() + "\n" +
    "Course: " + course.toString() + "\n"
}
