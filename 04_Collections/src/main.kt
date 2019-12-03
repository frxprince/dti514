fun main(args:Array<String>){
  // Immutable List
  var listx= listOf("hello","world",1234,1234.1,"hello",'A')
    println(listx.get(5))
    println(listx)
  for(item in listx){
    println(item.toString() +":" + item::class.simpleName )
  }
 // Mutable list
  var listy= mutableListOf("hello","world",1234,1234.1,"hello",'A')
  listy.add(0,"dti")
  println(listy)
}