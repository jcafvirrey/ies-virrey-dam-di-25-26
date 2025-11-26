fun main(){

    //Exercise_41

    //Definimos una lambda que multiplica un número por 5
    val multiplicarPor5: (Int) -> Int = { x -> x * 5 }

    //Llamamos a la función enviando el número y la lambda
    aplicarOperacion(8, multiplicarPor5)

    //Exercise_42

    //Definimos una lambda que:
    //    - Recibe un Int
    //    - Devuelve un Boolean
    //    - La condición "n % 2 == 0" devuelve true si es par, false si es impar
    val esPar= { n: Int -> n % 2 == 0 }

    //Llamamos a la lambda con un número
    val numero = 14
    val resultado_42 = esPar(numero)

    //Mostramos el resultado
    println("¿El número $numero es par? $resultado_42")

    //Exercise_43

    //Definimos una lambda que:
    //    - Recibe dos números enteros (a y b)
    //    - Devuelve el mayor de los dos
    //    - Usa una condición interna (if/else) para decidir
    val mayor: (Int, Int) -> Int = { a, b ->
        if (a > b) a else b
    }

    //Llamamos a la lambda con dos valores
    val resultado_43 = mayor(12, 7)

    //Mostramos el resultado
    println("El número mayor es: $resultado_43")

    //Exercise_44

    //Creamos una lambda usando la función anterior.
    //    Esta lambda siempre añadirá 10 al número que reciba.
    val sumar10 = crearSumador(10)

    // 4️⃣ Usamos la lambda resultante
    val resultado_44 = sumar10(5)   // 10 + 5 = 15

    // 5️⃣ Mostramos el resultado
    println("El resultado de sumar 10 a 5 es: $resultado_44")

    //Exercise_45
    
    // 3️⃣ Obtenemos la lambda llamando a la función
    val clasificar = crearClasificador()

    // 4️⃣ Probamos la lambda con distintos valores
    println(clasificar(10))   // Positivo
    println(clasificar(-4))   // Negativo
    println(clasificar(0))    // Cero

}

//Exercises_39
fun exercise_39(){
    //Definimos una expresión lambda
    //    - Recibe un Int (n)
    //    - Devuelve n * n
    //
    //    Sintaxis general de una lambda:
    //       { parámetros -> cuerpo }
    //
    val cuadrado: (Int) -> Int = { n -> n * n }

    //Llamamos a la lambda igual que si fuera una función normal
    val resultado = cuadrado(7)

    //Mostramos el resultado
    println("El cuadrado de 7 es: $resultado")
}

//exercise_40
fun exercise_40(){
    //Definimos una lambda que:
    //    - Recibe dos enteros (a y b)
    //    - Devuelve su suma
    //
    // Tipo función: (Int, Int) -> Int
    val sumar: (Int, Int) -> Int = { a, b -> a + b }

    //Llamamos a la lambda pasando dos enteros
    val resultado = sumar(10, 25)

    //Mostramos el resultado
    println("La suma de 10 y 25 es: $resultado")
}

//exercise_41
//Función que recibe:
//      - un número entero (n)
//      - una lambda (operacion) que recibe un Int y devuelve un Int
//
// Dentro de la función aplicamos la lambda al número recibido.
fun aplicarOperacion(n: Int, operacion: (Int) -> Int) {

    // Aplicamos la lambda igual que si fuera una función normal
    val resultado = operacion(n)

    // Mostramos el resultado
    println("El resultado de aplicar la operación es: $resultado")
}

//Exercise_44

//Esta función recibe un número 'x'
//    y devuelve una LAMBDA que suma ese número a otro número.
//
//    - Tipo de retorno: (Int) -> Int  → una función que recibe un Int y devuelve un Int.
//    - La lambda que devolvemos tendrá acceso a 'x' gracias al *closure* de Kotlin.
fun crearSumador(x: Int): (Int) -> Int {

    //Devolvemos una lambda que recibe un número 'y'
    //    y devuelve la suma x + y
    return { y -> x + y }
}

//Exercise_45
//Esta función no recibe parámetros.
//    Devuelve una LAMBDA que:
//       - Recibe un número entero (n)
//       - Devuelve un String indicando si es positivo, negativo o cero.
fun crearClasificador(): (Int) -> String {

    //Devolvemos la lambda directamente.
    //    Dentro usamos una expresión when para clasificar el número.
    return { n ->
        when {
            n > 0 -> "Positivo"
            n < 0 -> "Negativo"
            else -> "Cero"
        }
    }
}


