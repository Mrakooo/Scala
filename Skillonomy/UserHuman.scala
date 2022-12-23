
class UserHuman (var name: String,
                 var surname: String,
                 var age: Int,
                 var address: Address ){

  private var _name : String = name
  private var _surname : String = surname
  private var _age : Int = age
  private var _address : Address = address

  def Name: String = _name
  def Surame: String = _surname
  def Age: Int = _age
  def Address: Address = _address

  override def toString(): String = "---------------------" +
    "\n    User Data" +
    s"\nName: $name \nSurname: $surname \nAge: $age \nAdress: $address"
}

