fun main(args:Array<String>){
    var text:String?=null
    //text="hello world"
    println(text?.length)
    println(text)

    if(text==null){
        println("No data")
    }else{
        println(text)
    }
    println(text?:"No data")
    println(text?.length?:" Zero letter")

    var abcd= listOf(1,2,4,3,null,5,6,7,null,9)
    for (i in abcd)
    {
        println(i?:"empty")
    }

    for (i in abcd.filterNotNull())
    {
        println(i)
    }
}