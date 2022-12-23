class Course (var course_name: String,
              var cost: Int){

  private var _courseName: String = course_name
  private var _cost: Int = cost

  def Course_name: String = _courseName
  def Cost: Int = _cost

  override def toString(): String =
    s"\nCourse name: $course_name \nCost: $cost\n "
}