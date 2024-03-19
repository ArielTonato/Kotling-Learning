package com.aridev.androidcourse.syntaxis

fun main(){
    result("sdfa")
}

fun result (value:Any){
    when(value){
        is Int -> println("Es un entero")
        is String -> println("Es un string")
        is Double -> println("Es un double")
        else -> println("No se que es")
    }
}

fun getMonth(month:Int){
    //When es como un switch
    when(month){
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("Mes no valido")
    }
}

fun getTrimester(month:Int){
    //Esta chulisimo se aleja del switch
    when(month){
        in 1..3 -> println("Primer trimestre")
        in 4..6 -> println("Segundo trimestre")
        in 7..9 -> println("Tercer trimestre")
        in 10..12 -> println("Cuarto trimestre")
        !in 1..12 -> println("Mes no valido")
        //else -> println("Mes no valido")
    }
}

fun getTrimesterr(month:Int) = when(month){
        in 1..3 ->"Primer trimestre"
        in 4..6 -> "Segundo trimestre"
        in 7..9 -> "Tercer trimestre"
        in 10..12 -> "Cuarto trimestre"
        else -> "Mes no valido"
}