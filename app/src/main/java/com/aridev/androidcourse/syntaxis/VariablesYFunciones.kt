package com.aridev.androidcourse.syntaxis

fun main(){
    val resta:Int = restar(10, 5);
    println(resta)
    miEdad();
    val suma:Int = sumar(10, 5);
}

fun numericas(){
    /**
     *    Variables numericas
     *    val es una constante
     *    var es una variable
     */
    //Int -2,147,483,648 to 2,147,483,647
    val age:Int = 25;
    val age2:Int = 30;

    //Long -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
    val longNumber:Long = 30;


    //Float 32-bit floating point number
    val floatNumber:Float = 30.5f;

    //Double 64-bit floating point number
    val doubleNumber:Double = 30.5;

    //Operaciones
    println("Sumar")
    println(age + age2)

    println("Restar")
    println(age - age2)

    println("Multiplicar")
    println(age * age2)

    println("Dividir")
    println(age / age2)

    println("Modulo")
    println(age % age2)

}

fun alfanumericas(){
    /**
     * Variables alfanumericas
     */


    //Char solo soporta un caracter
    val letter:Char = 'A';

    //String soporta mas de un caracter
    val name:String = "Ari";

}

fun arrays(){
    /**
     * Arrays
     */
    val numbers = intArrayOf(1, 2, 3, 4, 5)
    val names = arrayOf("Ari", "Luis", "Juan")

    //Acceder a un elemento
    println(numbers[0])
    println(names[0])

    //Modificar un elemento
    numbers[0] = 10
    names[0] = "Ariana"

    //Recorrer un array
    for (number in numbers){
        println(number)
    }

    for (name in names){
        println(name)
    }

    //Tamaño de un array
    println(numbers.size)
    println(names.size)

}

fun booleanos(){
    /**
     * Variables booleanas
     */
    val isTrue:Boolean = true;
    val isFalse:Boolean = false;

    //Operaciones
    println(isTrue && isFalse)
    println(isTrue || isFalse)
    println(!isTrue)
}

//Funcion con parametros predefinidos
fun miEdad(age:Int = 22){
    println(age)
}

fun restar(numero1:Int, numero2:Int ):Int{
    return numero1 - numero2;
}

//Funcion simplificada
fun sumar(numero1:Int, numero2:Int ) = numero1 + numero2;