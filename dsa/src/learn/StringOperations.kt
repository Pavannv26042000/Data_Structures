package learn


// import Graphs.AlienGraph


fun main(){
    
    // con()
    // soperations("HII")

    // con2()

    array()
}



// fun soperations(str : String ): String{
//     var a = "str1"
//     var b = "Str2"

//     var c = a.plus(b)

//     var d = a.compareTo(b)

//     println(c)

//     println(d)


//     println(str)

//     return c
// }


// fun ktoJ(){
//     var k = AlienGraph()
    
// }


fun con(){
    var a = 4

   var day =  when(a){
        1 -> "print hi"
        else -> "Invalid day."
    }

    println(day)
}


fun con2(){
    var a = 0 
    while(a < 10 ){
        a++
        println("Hello")
    }
}



fun array(){
    var cars = arrayOf("bmw", "skoda")

    println(cars.size )


    cars[0]

    cars[1] = " audi"
    for(x in cars){
        println(x)
    }


   println( "bmw" in cars)
}