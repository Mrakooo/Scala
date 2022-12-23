
class Student ( name: String,
                surname: String,
                age: Int,
                address: Address,
                var group: Int,
                var account: Account )
  extends UserHuman(
    name,
    surname,
    age,
    address ) {

  private var _group: Int = group
  private var _account: Account = account
  private var _grade: Int = 0

  def Account: Account = _account
  def Group: Int = _group
  def Grade: Int = _grade

  def rate(value: Int) {
    _grade = value
  }


  def FundsExchange(currency: Int, exchange: Exchange) {
    exchange.ShowCourseInfo()
    var value_cash: Int = _account.cash
    var value_tokens: Int = _account.tokens
    var value_purchase_price_tokens: Double = exchange.Purchase_price_tokens
    var value_selling_price_tokens: Double = exchange.Selling_price_tokens
    var value_buying_tokens: Int = exchange.BuyingTokens(currency)
    _account.tokens = _account.tokens + value_buying_tokens
    _account.cash -= (value_buying_tokens * exchange.Purchase_price_tokens).toInt
  }


  def Remuneration(cost: Int, exchange: Exchange) {
    var value: Int = cost
    _grade match {
      case 1 =>
        value = (cost / 100) * 10
        if (value > _account.tokens) {
          FundsExchange(value - _account.tokens, exchange)
          _account.tokens -= value
        }
        else {
          _account.tokens -= value
        }

      case 2 =>
        value = (cost / 100) * 5
        if (value > _account.tokens) {
          FundsExchange(value - _account.tokens, exchange)
          _account.tokens -= value
        }
        else {
          _account.tokens -= value
        }

      case 4 =>
        value = (cost / 100) * 5
        _account.tokens += value

      case 5 =>
        value /= 10
        _account.tokens += value

      case _ =>  _account.tokens += 0
    }

  }


  def SaleAndPurchaseOfTokens(exchange: Exchange) {
    print("\n" + this.name + " " + this.surname + ":")
    print( "\n" + _account.tokens + " tokens on the account. ")
    println( "\n" + _account.cash + " funds on the account. ")
    //exchange.ShowCourseInfo()
    var value_cash: Int = _account.cash
    var value_tokens: Int = _account.tokens
    var value_purchase_price_tokens: Double = exchange.Purchase_price_tokens
    var value_selling_price_tokens: Double = exchange.Selling_price_tokens


    //println("--The algorithm will choose to BUY or SELL tokens--")
    var rand_choice: Int = scala.util.Random.between(1, 3)

    rand_choice match {

      case 1 =>
        println("--BUY--")
        println("This student can buy " + (value_cash / value_purchase_price_tokens) + " tokens \n Enter the desired quantity of tokens to buy: ")
        var quantity_of_tokens: Int = scala.io.StdIn.readInt()
        if (_account.cash < (quantity_of_tokens * exchange.Purchase_price_tokens).toInt) {
          println("This student doesn't have enough funds.")
        }
        else {
          var value_buying_tokens: Int = exchange.BuyingTokens(quantity_of_tokens)
          _account.tokens = _account.tokens + value_buying_tokens
          _account.cash -= (value_buying_tokens * exchange.Purchase_price_tokens).toInt

        }


      case 2 =>
        println("--SELL--")
        println("This student can receive " + (value_tokens * value_selling_price_tokens) + " funds \n Enter the quantity of tokens to sell: ")
        var quantity_of_tokens_2: Int = scala.io.StdIn.readInt()
        if (_account.tokens < quantity_of_tokens_2) {
          println("This student doesn't have enough tokens.")
        }
        else {
          var value_buying_tokens_2: Int = exchange.BuyingTokens(quantity_of_tokens_2)
          _account.cash = _account.cash + value_buying_tokens_2
          _account.tokens = _account.tokens - (value_buying_tokens_2 * exchange.Purchase_price_tokens).toInt
        }


      case _ =>
        println("----")

    }

  }


  override def toString(): String = "---------------------\n" +
    super.toString +
    "Account: " + account.toString() + "\n" +
    "Group: " + group.toString() + "\n" +
    "Grade: " + _grade.toString()
}