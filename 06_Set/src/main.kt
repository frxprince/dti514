fun main(args:Array<String>){
    // Immutable Set
   var alphabet= setOf("a","b","c","c","a","b","n")
    println(alphabet)
var text="Hello world dfsdfkfjdklfvhsdjkfvhdfghblfg"
    var symbols=text.toSet()
    println(symbols + ": " +  symbols.size)
    // Mutable set
    var alpha = mutableSetOf<String>()
    alpha.add("tom")
    alpha.add("john")
    alpha.add("tom")
    println(alpha)
}