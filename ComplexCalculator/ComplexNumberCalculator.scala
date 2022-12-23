object ComplexNumberCalculator {
  import scala.math.{pow, sqrt}

  case class Complex(realNum: Double, imagineNum: Double) extends Ordered[Complex] {
    private val modulus = sqrt(pow(realNum, 2) + pow(imagineNum, 2))

    def this(reNum: Double) = this(reNum, 0)

    def unary_+ = this

    def unary_- = new Complex(-realNum, -imagineNum)

    def unary_~ = new Complex(realNum, -imagineNum) // conjugate

    def unary_! = modulus

    def compare(that: Complex) = !this compare !that

    def +(c: Complex) = new Complex(realNum + c.realNum, imagineNum + c.imagineNum)

    def -(c: Complex) = this + -c

    def *(c: Complex) = new Complex(realNum * c.realNum - imagineNum * c.imagineNum,
      imagineNum * c.realNum + realNum * c.imagineNum)

    def /(c: Complex) = {
      require(c.realNum != 0 || c.imagineNum != 0)
      val d = pow(c.realNum, 2) + pow(c.imagineNum, 2)
      new Complex((realNum * c.realNum + imagineNum * c.imagineNum) / d, (imagineNum * c.realNum - realNum * c.imagineNum) / d)
    }

    override def toString() =
      this match {
        case Complex.i => "i"
        case Complex(realNum, 0) => realNum.toString
        case Complex(0, imagineNum) => imagineNum.toString + "*i"
        case _ => asString
      }

    private def asString =
      realNum + (if (imagineNum < 0) "-" + -imagineNum else "+" + imagineNum) + "*i"
  }

  object Complex {
    val i = new Complex(0, 1)

    def apply(re: Double) = new Complex(re)

    implicit def fromDouble(d: Double) = new Complex(d)
    implicit def fromFloat(f: Float) = new Complex(f)
    implicit def fromLong(l: Long) = new Complex(l)
    implicit def fromInt(i: Int) = new Complex(i)
    implicit def fromShort(s: Short) = new Complex(s)
  }

  //import Complex._

}
