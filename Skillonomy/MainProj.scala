
import scala.io.StdIn
import scala.collection.mutable.ListBuffer


object MainProj {
  def main(args: Array[String]): Unit ={

    var exchange = new Exchange()
    var cycles = new Cycles()

    var student_1 =
      new Student("Andriy", "Marchenko", 18,
      new Address("Ukraine", "Kherson", "Patona", 27),
        241,
      new Account(1000, 5000))

    var student_2 =
      new Student("Margarita", "Shevchik", 18,
        new Address("Ukraine", "Kherson", "Koltsova", 41),
        241,
        new Account(1000, 5000))

    var student_3 =
      new Student("Dasha", "Ivanova", 18,
        new Address("Ukraine", "Kherson", "Senyavina", 9),
        241,
        new Account(1000, 5000))

    var student_4 =
      new Student("Oleksandr", "Maidanika", 19,
        new Address("Ukraine", "Kherson", "Senyavina", 9),
        241,
        new Account(1000, 5000))


    var teacher_1 =
      new Teacher("Charlie", "Clark", 30,
      new Address("Ukraine", "Odessa", "Perekopskaya", 14),
      new Account(5000, 5000), new Course("Fundamentals of software engineering", 900))

    var teacher_2 =
      new Teacher("Hanna", "Turner", 26,
        new Address("Ukraine", "Kryvyi Rih", "200 years of Kryvyi Rih", 32),
        new Account(5000, 5000), new Course("Graphic design", 900))


    teacher_1.AddStudentToList(student_4)
    teacher_1.AddStudentToList(student_3)
    teacher_2.AddStudentToList(student_2)
    teacher_2.AddStudentToList(student_1)

    cycles.AddTeacherToList(teacher_1)
    cycles.AddTeacherToList(teacher_2)

    cycles.CyclesRunner(exchange)

  }

}
