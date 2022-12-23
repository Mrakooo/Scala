
class Account (var tokens: Int , var cash: Int){
  private var _tokens: Int = tokens
  private var _cash: Int = cash

  def Tokens: Int = _tokens
  def Cash: Int = _cash

  override def toString(): String =
    s"\nTokens: $tokens \nCash: $cash"

}