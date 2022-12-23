
class Address (var country: String,
               var city: String,
               var street: String,
               var house: Int){

  override def toString(): String =
    s"\nCountry: $country \nCity: $city \nStreet: $street \nHouse: $house\n"
}
