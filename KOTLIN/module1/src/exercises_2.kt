fun main(){
//    exercise_10()
//    exercise_11()
//    exercise_12()
//    exercise_13()
//    exercise_14()
//    exercise_15()
//    exercise_16()
//    exercise_17()
//    exercise_18()
//    exercise_19()
}
fun exercise_10(){
    //Declaramos un Array de 5 enteros con valores iniciales.
    //Usamos arrayOf() para crear un array y asignar directamente sus valores.
    val numeros = arrayOf(10, 20, 30, 40, 50)

    //Informamos al usuario de lo que vamos a mostrar.
    println("Mostrando los elementos del array:")

    //Recorremos el array usando un bucle for.
    //    'i' representa el índice de cada elemento del array.
    //    'numeros.indices' devuelve el rango válido de posiciones (0..4 en este caso).
    for (i in numeros.indices) {
        //Accedemos a cada elemento usando su índice y lo imprimimos.
        println("Elemento en la posición $i: ${numeros[i]}")
    }
}
fun exercise_11(){
    //Creamos un IntArray de tamaño 5.
    //Un IntArray es un array específico de enteros, más eficiente que arrayOf().
    //Todos los valores iniciales serán 0.
    val numeros = IntArray(5)

    //Pedimos al usuario que introduzca 5 números.
    println("Introduce 5 números enteros:")

    // Recorremos el array usando sus índices: 0, 1, 2, 3 y 4.
    for (i in 0 until numeros.size) {

        // Mostramos qué número se está pidiendo al usuario
        println("Introduce el número ${i + 1}:")

        // Leemos el dato como Int
        val aux = readLine()!!.toInt()

        // Guardamos el número introducido en la posición correspondiente
        numeros[i] = aux
    }

    //Mostramos todos los números introducidos
    println("Los números que has introducido son:")

    for (i in 0 until numeros.size) {
        println("Posición ${i + 1}: ${numeros[i]}")
    }
}
fun exercise_12(){
    //Declaramos un array de enteros con algunos valores iniciales.
    //Puedes pedir los datos al usuario.
    val numeros = arrayOf(5, 10, 15, 20, 25)

    //Declaramos una variable 'suma' que actuará como acumulador.
    //Empezamos en 0 porque aún no hemos sumado nada.
    var suma = 0

    //Recorremos el array con un bucle for.
    //'i' recorre los índices válidos del array.
    for (i in numeros.indices) {

        // Vamos acumulando cada elemento de la lista en la variable 'suma'
        suma += numeros[i]
    }

    //Mostramos el resultado final
    println("La suma de todos los elementos del array es: $suma")
}
fun exercise_13(){
    //Creamos un IntArray de tamaño 6 donde guardaremos los números del usuario
    val numeros = IntArray(6)

    println("Introduce 6 números enteros:")

    //Rellenamos el array leyendo los valores del usuario
    for (i in 0 until numeros.size) {
        println("Introduce el número ${i + 1}:")
        val aux = readLine()!!.toInt()  // Leemos cada número como entero
        numeros[i] = aux                // Guardamos el número en la posición correspondiente
    }

    //Declaramos variables para el mayor y el menor
    //Inicializamos ambos con el primer elemento del array para empezar la comparación
    var mayor = numeros[0]
    var menor = numeros[0]

    //Recorremos el array para encontrar el mayor y el menor
    for (i in 1 until numeros.size) {   // Empezamos en 1 porque ya usamos la posición 0
        val actual = numeros[i]

        // Si el número actual es mayor que el que tenemos guardado, lo actualizamos
        if (actual > mayor) {
            mayor = actual
        }

        // Si el número actual es menor que el que tenemos guardado, lo actualizamos
        if (actual < menor) {
            menor = actual
        }
    }

    //Mostramos los resultados al usuario
    println("El número mayor es: $mayor")
    println("El número menor es: $menor")
}
fun exercise_14(){
    //Creamos una lista mutable con 10 números enteros.
    //mutableListOf() permite añadir, quitar o modificar elementos.
    val numeros = mutableListOf(3, 8, 12, 5, 7, 20, 14, 9, 2, 11)

    //Creamos una variable para contar los números pares.
    var contadorPares = 0

    //Recorremos la lista elemento por elemento.
    //Cada elemento se almacena temporalmente en la variable 'n'.
    for (n in numeros) {

        //Un número es par cuando, al dividirlo entre 2, su resto es 0.
        if (n % 2 == 0) {
            contadorPares++  // Aumentamos el contador en 1
        }
    }

    //Mostramos el resultado final al usuario.
    println("La lista contiene $contadorPares números pares.")
}
fun exercise_15(){
    //Lista original con algunos valores
    //Puede ser mutable o inmutable, en este caso usamos listOf()
    val numeros = listOf(10, 20, 30, 40, 50)

    //Creamos una nueva lista mutable donde guardaremos los elementos invertidos
    val listaInversa = mutableListOf<Int>()

    //Recorremos la lista original desde el último índice hasta el primero
    //numeros.size - 1 es el índice final (última posición)
    for (i in numeros.size - 1 downTo 0) {

        //Añadimos cada elemento a la nueva lista en orden inverso
        listaInversa.add(numeros[i])
    }

    //Mostramos ambas listas para comparar
    println("Lista original: $numeros")
    println("Lista invertida: $listaInversa")
}
fun exercise_16(){
    //Declaramos una lista de cadenas
    //Como es una lista fija de ejemplo, usamos listOf()
    val nombres = listOf("Marian", "Pablo", "Sergio", "Jorge", "Adrian")

    //Pedimos al usuario el texto que quiere buscar en la lista
    println("Introduce un nombre para buscar en la lista:")
    val aux = readLine()!!.toString()   // Leemos la búsqueda como String

    //Variable booleana que nos dirá si encontramos o no el texto
    var encontrado = false

    //Recorremos la lista comparando cada elemento con el texto introducido
    for (nombre in nombres) {

        // Si encontramos una coincidencia exacta, marcamos encontrado como true
        if (nombre == aux) {
            encontrado = true
            break   // Terminamos el bucle porque ya no hace falta seguir buscando
        }
    }

    //Mostramos el resultado al usuario
    if (encontrado) {
        println("El nombre \"$aux\" SÍ se encuentra en la lista.")
    } else {
        println("El nombre \"$aux\" NO se encuentra en la lista.")
    }
}
fun exercise_17(){
    //Creamos una lista mutable con valores repetidos
    val numeros = mutableListOf(3, 7, 3, 2, 7, 9, 2, 1, 9)

    //Creamos una nueva lista mutable que almacenará
    //solo los valores únicos, sin duplicados
    val sinDuplicados = mutableListOf<Int>()

    //Recorremos la lista original elemento por elemento
    for (n in numeros) {

        //Comprobamos si el número NO está en la lista sin duplicados
        //Esto evita que se repita en la nueva lista
        if (!sinDuplicados.contains(n)) {

            //Si no estaba, lo añadimos
            sinDuplicados.add(n)
        }
    }

    //Mostramos ambas listas para comparar el resultado
    println("Lista original: $numeros")
    println("Lista sin duplicados: $sinDuplicados")
}
fun exercise_18(){
    //Declaramos dos arrays de enteros con el mismo tamaño
    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(4, 5, 6)

    //Creamos un tercer array para almacenar las sumas
    //Tiene el mismo tamaño que los otros dos
    val resultado = IntArray(array1.size)

    //Recorremos los arrays usando sus índices
    //Como tienen el mismo tamaño, cualquier índice válido sirve para ambos
    for (i in array1.indices) {

        //Cada posición del array resultado será la suma de los valores correspondientes
        resultado[i] = array1[i] + array2[i]
    }

    //Mostramos los tres arrays para comprobar el resultado
    println("Array 1: ${array1.joinToString()}")
    println("Array 2: ${array2.joinToString()}")
    println("Suma elemento a elemento: ${resultado.joinToString()}")
}
fun exercise_19(){
    //Lista inicial de enteros
    val numeros = listOf(4, 12, 7, 18, 3, 22, 15, 10, 30)

    //Nueva lista mutable donde guardaremos solo los números válidos
    val filtrados = mutableListOf<Int>()

    //Recorremos la lista original elemento por elemento
    for (n in numeros) {

        //Comprobamos las dos condiciones:
        //    - que el número sea mayor que 10
        //    - y que además sea par (n % 2 == 0)
        if (n > 10 && n % 2 == 0) {

            //Si cumple ambas condiciones lo añadimos a la nueva lista
            filtrados.add(n)
        }
    }

    //Mostramos ambas listas para comprobar el resultado
    println("Lista original: $numeros")
    println("Números mayores que 10 y pares: $filtrados")
}

