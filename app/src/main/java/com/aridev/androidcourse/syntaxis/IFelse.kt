package com.aridev.androidcourse.syntaxis

fun main(){

}

fun IFelse(){
    /**
     *    IF ELSE
     */
    val age:Int = 25;
    val age2:Int = 30;

    if(age > age2){
        println("Age is greater than age2")
    }else{
        println("Age is less than age2")
    }

    if(age > age2){
        println("Age is greater than age2")
    }else if(age < age2){
        println("Age is less than age2")
    }else{
        println("Age is equal to age2")
    }

    val result = if(age > age2) "Age is greater than age2" else "Age is less than age2"
    println(result)
}