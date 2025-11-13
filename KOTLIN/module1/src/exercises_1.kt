fun main(){
//    exercise_1()
//    exercise_2()
//    exercise_3()
//    exercise_4()
//    exercise_5()
//    exercise_6()
//    exercise_7()
//    exercise_8()
//    exercise_9()
}
fun exercise_1(){
//Pedimos el primer número al usuario
    println("Introduce el primer número entero:")
    val aux = readLine()!!.toInt()   // Leemos y convertimos la entrada a Int

    //Pedimos el segundo número
    println("Introduce el segundo número entero:")
    val aux2 = readLine()!!.toInt()  // Leemos el segundo número

    // Realizamos las operaciones aritméticas básicas
    val suma = aux + aux2             // Suma
    val resta = aux - aux2            // Resta
    val multiplicacion = aux * aux2   // Multiplicación

    //Para evitar error por división entre cero, comprobamos el divisor
    val division = if (aux2 != 0) aux / aux2 else null
    val modulo = if (aux2 != 0) aux % aux2 else null

    //Mostramos los resultados de forma clara
    println("Resultados de las operaciones entre $aux y $aux2:")
    println("Suma: $suma")
    println("Resta: $resta")
    println("Multiplicación: $multiplicacion")

    // Si aux2 es 0, informamos al usuario del error en división
    if (aux2 == 0) {
        println("División: No se puede dividir entre cero")
        println("Módulo: No se puede calcular el resto con divisor cero")
    } else {
        println("División: $division")
        println("Módulo: $modulo")
    }
}
fun exercise_2(){
    //Pedimos un número decimal al usuario
    println("Introduce un número decimal (por ejemplo 12.5):")
    val aux = readLine()!!.toDouble()   // Leemos como Double porque el usuario introduce un decimal

    //Realizamos las conversiones de tipo
    val entero = aux.toInt()            // Conversión a número entero (trunca la parte decimal)
    val flotante = aux.toFloat()        // Conversión a tipo Float
    val cadena = aux.toString()         // Conversión a String (texto)

    //Mostramos los resultados
    println("== Resultados de la conversión del número $aux ==")
    println("Como entero (Int): $entero")
    println("Como flotante (Float): $flotante")
    println("Como cadena (String): $cadena")

}
fun exercise_3(){
    //Declaramos PI como una constante utilizando 'val'
    //Es buena práctica usar nombres en mayúsculas para constantes matemáticas.
    val PI = 3.141592653589793

    //Pedimos al usuario que introduzca el radio
    println("Introduce el radio del círculo (entero):")
    val aux = readLine()!!.toInt()   // Leemos el radio como Int

    //Convertimos el radio a Double para poder obtener un resultado más preciso
    val radio = aux.toDouble()

    //Calculamos el área y la circunferencia (perímetro)
    val area = PI * radio * radio
    val circunferencia = 2 * PI * radio

    //Mostramos los resultados
    println("== Resultados para un círculo de radio $radio ==")
    println("Área: $area")
    println("Circunferencia (perímetro): $circunferencia")
}
fun exercise_4(){
    //Pedimos la edad al usuario
    println("Introduce tu edad (entero):")
    val aux = readLine()!!.toInt()   // Leemos la edad como Int

    //Evaluamos si es mayor o menor de edad
    //Condición: una persona es adulta si tiene 18 años o más.
    val mensaje = if (aux >= 18) {
        "Eres mayor de edad."
    } else {
        "Eres menor de edad."
    }

    //Mostramos el resultado
    println(mensaje)
}
fun exercise_5(){
    //Pedimos un número entre 1 y 5 al usuario
    println("Introduce un número entre 1 y 5:")
    val aux = readLine()!!.toInt()   // Leemos el número como Int

    //Usamos 'when' para traducir el número a su representación en inglés
    val palabra = when (aux) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        else -> "Número fuera del rango (1-5)."  // Caso por defecto
    }

    //Mostramos el resultado
    println(palabra)
}
fun exercise_6(){
    //Informamos al usuario de lo que va a hacer el programa
    println("Mostrando los números del 1 al 10:")

    //Bucle for: recorre el rango 1..10
    //    El operador '..' crea un rango inclusivo: incluye el 1 y también el 10.
    for (i in 1..10) {
        println(i)  // Mostramos cada número
    }
}
fun exercise_7(){
    //Pedimos al usuario un número entero positivo
    println("Introduce un número entero positivo:")
    val aux = readLine()!!.toInt()   // Leemos el número desde teclado

    //Creamos una variable que irá disminuyendo en el bucle
    var contador = aux

    //Bucle while:
    //Se ejecuta mientras 'contador' sea mayor o igual que 1.
    println("Mostrando los números desde $aux hasta 1:")
    while (contador >= 1) {
        println(contador)
        contador--    // Reducimos el valor en 1 en cada iteración
    }
}
fun exercise_8(){
    //Pedimos al usuario un número entero
    println("Introduce un número entero:")
    val aux = readLine()!!.toInt()   // Leemos la entrada como Int

    //Comprobamos si el número está dentro del rango 1..100
    //El operador 'in' verifica si el valor pertenece al rango especificado.
    val mensaje = if (aux in 1..100) {
        "Within the range"          // Dentro del rango
    } else {
        "Out of range"              // Fuera del rango
    }

    //Mostramos el resultado
    println(mensaje)
}
fun exercise_9(){
    // Declaramos un array de 5 enteros
    // Inicialmente estará lleno de ceros.
    val numeros = IntArray(5)

    //Pedimos al usuario que introduzca cada uno de los 5 valores
    println("Introduce 5 números enteros:")

    for (i in 0 until numeros.size) {
        //Este array podría sustituirse por for(i in numeros.indices)
        println("Introduce el número ${i + 1}:")
        val aux = readLine()!!.toInt()   // Leemos cada número introducido por el usuario
        numeros[i] = aux                 // Guardamos el valor en la posición correspondiente
    }

    // 3️⃣ Mostramos el contenido completo del array
    println("Los números introducidos son:")

    // Recorremos el array y mostramos cada elemento
    for (i in numeros.indices) {
        println("Posición ${i + 1}: ${numeros[i]}")
    }
}