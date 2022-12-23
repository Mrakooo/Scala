
class Exchange() {

  private var quantity_of_tokens: Int = scala.util.Random.nextInt(20000)+ 4000
  private var quantity_of_cash: Int = scala.util.Random.nextInt(20000)+ 4000


  private var purchase_price_tokens : Double = (scala.util.Random.nextDouble()+ 0.7)
  private var selling_price_tokens : Double = (scala.util.Random.nextDouble()+ 0.5)

  def CourseUpdate() {
    this.purchase_price_tokens = (scala.util.Random.nextDouble() + 0.7)
    this.selling_price_tokens = (scala.util.Random.nextDouble() + 0.5)
  }

  def Quantity_of_tokens: Int = quantity_of_tokens
  def Quantity_of_cash: Int = quantity_of_cash
  def Purchase_price_tokens: Double = purchase_price_tokens
  def Selling_price_tokens: Double = selling_price_tokens

  def ShowCourseInfo(){
    println("    Course info")
    println("Purchase price of one token: " + purchase_price_tokens)
    println("The cost of selling one token: " + selling_price_tokens)
  }


  def BuyingTokens(count: Int): Int = {
    var TokenBack: Int = 0
    if (quantity_of_tokens < count) {
      println("There isn't enough tokens on the Exchange." +
        " \n You can buy " + quantity_of_tokens + " tokens.")
      quantity_of_cash = quantity_of_cash + (quantity_of_tokens * purchase_price_tokens).toInt
      quantity_of_tokens -= quantity_of_tokens
      return quantity_of_tokens
    }

    else {
      quantity_of_cash = quantity_of_cash + (count * purchase_price_tokens).toInt
      quantity_of_tokens -= count
      TokenBack = count
    }

    return TokenBack.toInt
  }


  def SellTokens(count:Int):Int=
  {
    var CashBack : Int = 0
    if(quantity_of_cash < (count * selling_price_tokens).toInt){
      println("There isn't enough money on the Exchange. " +
        "\n You can sell " + (quantity_of_cash) + " money.")
      quantity_of_tokens = quantity_of_tokens + (quantity_of_cash *selling_price_tokens).toInt
      quantity_of_cash = quantity_of_cash - quantity_of_cash
      CashBack = quantity_of_cash
    }

    else{
      quantity_of_tokens += count
      quantity_of_cash = quantity_of_cash - (count * selling_price_tokens).toInt
      CashBack = (count * selling_price_tokens).toInt
    }

    return CashBack.toInt
  }

}