
import scala.collection.mutable.ListBuffer

class Cycles(){
  var _teacher_buflist = ListBuffer[Teacher]()
  var quantity_of_cycles: Int = 3

  //println("Enter quantity of cycles: ")
  //quantity_of_cycles = scala.io.StdIn.readInt()

  println(s"The quantity of cycles: $quantity_of_cycles")

  def AddTeacherToList(teacher: Teacher) : Unit ={
    _teacher_buflist += teacher
  }

  def ShowInfoTeacher(): Unit = {
    for (i <- 0 until _teacher_buflist.length) {
      println("\n" + this._teacher_buflist(i).toString)
    }
  }

  def CyclesRunner(exchange: Exchange){
    for(cycle_counter <- 0 until quantity_of_cycles){
      var value : Int = cycle_counter + 1
      println("=-=-=-=-=-=-=-=-=-\n" + value + " cycle")

      for(teacher_counter <- 0 until _teacher_buflist.length){

        _teacher_buflist(teacher_counter).GiveGrades()
        _teacher_buflist(teacher_counter).toString

        for(student_counter <- 0 until _teacher_buflist(teacher_counter)._student_buflist.length){

          _teacher_buflist(teacher_counter)._student_buflist(student_counter).Remuneration(_teacher_buflist(teacher_counter).course.Cost, exchange)
          /////////////////
          _teacher_buflist(teacher_counter)._student_buflist(student_counter).SaleAndPurchaseOfTokens(exchange)

        }

        _teacher_buflist(teacher_counter).ShowInfoStudent()
        _teacher_buflist(teacher_counter).Payment(exchange)

      }

      ShowInfoTeacher()
      exchange.CourseUpdate()
    }
  }

}