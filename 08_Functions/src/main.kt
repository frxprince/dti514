fun main(args:Array<String>){
    println(add(5,2))
    println(add(b=2,a=5))
    println(mul(2,5))
    println(mul(2))
    println(sub(5,2))
    println("%.10f".format(.00001))
    printme(0.000001)
}
// short hand function
fun sub(a:Int,b:Int):Int=a-b
fun printme(a:Double):Unit=println("%.10f".format(a))
// function
fun add(a:Int,b:Int):Int
{  println("a = $a ,  b = $b")
   return a+b
}
// function with default value
fun mul(a:Int,b:Int=1):Int
{
    println("a = $a ,  b = $b")
    return a*b
}