package com.aridev.androidcourse.syntaxis

fun main(){

    //inmutableList();
    mutableList();
    
}
fun mutableList(){
    var weekDays:MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    //Recibe la posicion y el valor
    weekDays.add(0,"AriDay")
    println(weekDays);
}

fun inmutableList(){
    //Este tipo de lista es inmutable
    val readOnly: List<String> = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

    println(readOnly.size);
    println(readOnly);

    //El ultimo valor de la lista
    //println(readOnly.last());

    //El primer valor de la lista
    //println(readOnly.first());

    //Filtrar
    /*val example = readOnly.filter {  it.contains("s")};
    println(example);*/

    readOnly.forEach{ weekDay -> println(weekDay) }
}
