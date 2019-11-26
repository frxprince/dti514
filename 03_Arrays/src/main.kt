fun main(args:Array<String>){

   var X = Array<Int>(3,init={index->index+1})
   var X2 = Array<String>(3,init={index->"hello world $index"})
   println(X[0])
   println(X[1])
   println(X[2])

   println(X2[0])
   println(X2[1])
   println(X2[2])
   X2.set(0,"DTI")
   //X2[0]="DTI"
   println(X2.get(0))

   var country= arrayOf("th","en","jp","us")
   country.sort()
   for(item in country){
      println(item)
   }

   var num= arrayOfNulls<Int>(10)
   num[1]=30
   println(num[1])

}