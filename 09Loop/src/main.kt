fun main(args:Array<String>){
    var text="Hello world"
    var j=0
    for (i in text.toCharArray())
    {
        println(j.toString() + " : "+i)
        j++
    }

    for((ind,item) in text.toCharArray().withIndex()){
      println(" $ind : $item ")
    }
    //--------- for + range
    for (i in 0..10)print(" $i ")
    println()
    for (i in 0..10 step 2)print(" $i ")
    println()
    for(i in 10 downTo 0 )print(" $i ")
    println()
    for(i in 10 downTo 0  step 2)print(" $i ")

  // ----- repeat
    repeat(5){ println("Hello World")}
  //------ while
    var i=1
    while (i<10){
        println("Wait")
        i++
    }
 //------ do
    var k=100
    do {
        println("Do")
        k++
    }while (k<10)
  //---------------- break and continue
    for (i in 0..10){
        if (i ==5)
            continue
        if (i == 8)
            break
        print(" $i ")
        print(",")
    }
 //-------
loop1@    for (i in 0..5){
loop2@        for(j in 0..6){
            if(i==3)
                break@loop1
          print("($i $j) ")
        }
        println()
    }
}
