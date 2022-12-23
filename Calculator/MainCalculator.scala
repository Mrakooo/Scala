

object MainCalculator {
  def main(args: Array[String]): Unit = {
    var FirstNum: Double = 0
    var SecondNum: Double = 0
    var result: Double = 0
    var operator: Char = 0


    System.out.println("Indicate the operation" + " \n" + "+, -, *, /, %")
    operator = scala.io.StdIn.readChar()
    System.out.println("Enter the first number: ")
    FirstNum = scala.io.StdIn.readDouble()
    System.out.println("Enter the second number: ")
    SecondNum = scala.io.StdIn.readDouble()


    operator match {
      case '+' =>
        result = FirstNum + SecondNum
        System.out.println(FirstNum + " + " + SecondNum + " = " + result)

      case '-' =>
        result = FirstNum - SecondNum
        System.out.println(FirstNum + " - " + SecondNum + " = " + result)

      case '*' =>
        result = FirstNum * SecondNum
        System.out.println(FirstNum + " * " + SecondNum + " = " + result)

      case '/' =>
        result = FirstNum / SecondNum
        System.out.println(FirstNum + " / " + SecondNum + " = " + result)

      case '%' =>
        result = FirstNum % SecondNum
        System.out.println(FirstNum + " % " + SecondNum + " = " + result)

      case _ =>
        System.out.println("Enter the valid operation")
    }

  }
}
