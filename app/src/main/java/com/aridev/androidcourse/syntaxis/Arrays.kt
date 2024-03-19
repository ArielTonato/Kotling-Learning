package com.aridev.androidcourse.syntaxis

fun main(){

    //Los arrays se declaran con arrayOf
    val weekDays = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

    println(weekDays[0]);

    for (position in weekDays.indices){
        println(position);
    }

    for ( (index, value) in weekDays.withIndex()){
        println("The day $value is in the position $index");
    }
}