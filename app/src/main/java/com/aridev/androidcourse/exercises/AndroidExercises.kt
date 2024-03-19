package com.aridev.androidcourse.exercises

fun main(){
    /**
    val morningNotification = 51;
    val afternoonNotification = 135;
    exe1(morningNotification);
    exe1(afternoonNotification);*/

    /*val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")*/

}

fun exe1(quantityMessages:Int){
    if(quantityMessages >= 100){
        println("Your phone is going to explode you have more than 99+ notifications")
    }else {
        println("Tienes $quantityMessages mensajes")
    }
}

fun ticketPrice(age: Int, isMonday: Boolean) = when (age) {
        in 0..12 ->  15
        in 13..60 ->  if (isMonday) 25 else 30
        in 61..100 ->  20
        else ->  -1
    }

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}