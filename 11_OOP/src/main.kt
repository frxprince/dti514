fun main(args:Array<String>){
    var x=shape()
    x.height=100.0
    x.width=200.0
    x.area=2.0
    println(x.area)
    var x2=shape2(100.0,200.0)
    var x3=Rectangle(10.0,20.0)
    x3.find_area()
    x3.print_area()
    var x4=Square(10.0)
    x4.find_area()
    x4.print_area()
    var x5=Circle(2.0)
    x5.find_area()
    x5.print_area()

    var x6=AnyShape(5.0,10.0)
    x6.find_any_area(object:anyArea{
        override fun find_any_area(w: Double, h: Double): Double {
         return h*w*0.5
        }

    })
    x6.print_area()


}

open class shape2(var width:Double=0.0 ,var height:Double=0.0){
    var area:Double=0.0
    init {
        println("Shape 2 is constructing $width  $height")
    }
}
open class Rectangle(var w:Double=0.0,var h:Double=0.0):shape2(w,h){
   open fun find_area(){
        area=w * h
    }
    fun print_area(){
        println("area = $area")
    }
}
open class Square( var w2:Double=0.0):Rectangle(w2,w2)
open class Circle(var r:Double=0.0):Square(r){
    override fun find_area() {
        area=Math.PI * r * r
    }
}

class AnyShape(w:Double=0.0,h:Double=0.0):Rectangle(w,h)
{
   fun find_any_area(Calculator:anyArea){
       area=Calculator.find_any_area(width,height)
   }
}

interface anyArea{
    fun find_any_area(w:Double,h:Double):Double
}






class shape{
    var width:Double=0.0
    var height:Double=0.0
    var area:Double=0.0
    init { println("Shape is constructing")    }
}