fun main(args:Array<String>){
    var a:String
    a="Hello world \n is newline \t is tab"  // Escape String
    var b= "Hello world \\n is newline \\t is tab"  // Escape String
    var c="""Hello world \n is newline \t is tab"""  // raw String
    var d="""java.lang.NoSuchMethodError:
 'void com.intellij.credentialStor
	e.CredentialAttributes.<init>(java.lang.Stri
	ng, java.lang.String, java.lang.Class, boolean, in
t, kotlin.jvm.internal.DefaultConstructorMarker)'"""
    println(a)
    println(b)
    println(c)
    println(d)

 //   var e="abcd"
 //   var f = readLine()
 //   println(e==f)
  var g=" val 1= $a  val 2=$b   val 3=$c   val 4 =$d " // String template
    println(g)

var i=100
    var j=200
    var k=i+j
println("the answer is "+ k.toString())
    println(" the answer is $k")
    println(" the answer is ${i+j}")
var str1="1234"
    var str2="5678"
    println(str1.toInt()+str2.toFloat())
    println(  (str1.toInt()+str2.toFloat())::class.simpleName   )






}