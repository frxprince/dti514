fun main(args:Array<String>){
    val pi:Double = 3.14159 //Immutable
    var a:Int=1234    // Mutable
    println(pi)
    println(a)
    a=5678
    println(a)
    var b=1234
    var c:Double=1.0
    println(b)
  println(c::class.simpleName)  // :: = reflection
   //-----------
     var h= readLine()!!.toInt()
     var w = readLine()!!.toInt()
    var area=h*w
    println(area)
}