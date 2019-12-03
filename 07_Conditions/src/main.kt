fun main(args:Array<String>){
    var score=51
    var grade:String="X"
    if (score>=80)
    {
        grade="A"
    }else if (score>=70)
    {
        grade="B"
    }else if (score>=60)
    {
        grade="C"
    }else if (score>=50)
    {
        grade="D"
    }else{
        grade="F"
    }
    println(grade)

    // if as a statement
    var gradex = if (score>=80)
        "A"
    else if (score>=70)
        "B"
    else if (score>=60)
        "C"
    else if (score>=50)
        "D"
    else
        "F"
    println(gradex)

    println( if (score>=50)"pass" else "fail"  )

    // when statement
  var lang="xx"
  var name:String="x"
    when(lang){
        "th" ->name="Thai"
        "en" -> name="English"
        "jp" -> name="Japan"
        else -> name=" I don't know"
    }
    println(name)
// when as a statement
    var name2=when(lang){
        "th" -> "Thai"
        "en" -> "English"
        "jp" -> "Japan"
        else -> " I don't know"
    }
    println(name2)
}