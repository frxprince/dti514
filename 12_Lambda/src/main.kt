fun main(args:Array<String>){
    var a= listOf<Int>(5,4,3,2,5,6,8,6,5,1,3,2,2,0,5,66)
    println(a)
    var b=SortArray(a)
    println(b)
    var c=SortArray(a){
            X:List<Int> -> X.sortedDescending()
            }
    println(c)
    EveryItem(a){
        i-> println(i)
        println("hello")
    }
}

fun SortArray(x:List<Int>):List<Int>{
    return x.sorted()
}
fun SortArray(x:List<Int>,sorter:(List<Int>)->List<Int>):List<Int>{
    return sorter(x)
}
fun EveryItem(X:List<Int>,myAction:(Int)->Unit){
    for (item in X)
    {
        myAction(item)
    }
}