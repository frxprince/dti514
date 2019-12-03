fun main(args:Array<String>){
    // Immutable map
    var grades= mapOf( Pair(0,"F"),Pair(1,"D"),Pair(2,"C"),
        Pair(3,"B"),Pair(4,"A"))
    println(grades.get(2))

    var scores= mapOf(Pair("F",0),Pair("D",1),Pair("C",2),Pair("B",3),Pair("A",4))
    println(scores.get("B"))
    // Mutable map
    var lang= mutableMapOf<String,String>()
    lang.put("th","Thai")
    lang.put("en","English")
    println(lang)
    println(lang.get("th"))
    println("xx" in lang)
}