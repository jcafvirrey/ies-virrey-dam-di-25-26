fun main(){
//    exercise_20()
//    exercise_21()
//    exercise_22()
//    exercise_23()
//    exercise_24()
//    exercise_25()
//    exercise_26()
//    exercise_27()
//    exercise_28()

}
fun exercise_20(){
    //Declaramos una variable de tipo String? (nullable)
    //El signo ? indica que la variable puede contener texto o puede valer null.
    val nombre: String? = null

    //Imprimimos su contenido por pantalla.
    //Al ser null, se mostrará literalmente la palabra "null".
    println(nombre)
}
fun exercise_21(){
    //Declaramos una variable String? (nullable) con un valor inicial
    var texto: String? = "Kotlin"

    //Mostramos la longitud inicial usando ?.length
    //Como texto NO es null, ?.length devolverá la longitud real.
    println("Longitud inicial: ${texto?.length}")   // Imprime: 6

    //Ahora cambiamos el valor a null
    texto = null

    //Volvemos a imprimir la longitud
    //Como texto AHORA sí es null, ?.length devolverá null en lugar de fallar.
    println("Longitud después de asignar null: ${texto?.length}") // Imprime: null
}
fun exercise_22(){
    //Declaramos una variable String? llamada 'ciudad'
    //Al no asignarle valor, automáticamente es null.
    val ciudad: String? = null

    //Usamos ciudad?.length ?: 0
    //    - ciudad?.length  → devuelve la longitud si ciudad NO es null
    //    - ?: 0            → si es null, devolvemos 0 como valor por defecto
    val longitud = ciudad?.length ?: 0

    //Mostramos el resultado por pantalla
    println("Longitud de la ciudad: $longitud")
}
fun exercise_23(){
    //Pedimos al usuario una cadena de texto.
    //readLine() devuelve un String? (puede ser null si el usuario no escribe nada).
    println("Introduce una cadena (puede estar vacía):")
    val texto = readLine()   // Tipo: String?

    //Queremos mostrar el primer carácter si existe.
    //    Para ello usamos:
    //        texto?.first()
    //    - Si texto NO es null → devuelve su primer carácter
    //    - Si texto ES null    → devuelve null
    //
    //    Y combinamos con ?: para sustituir null por "Sin dato".
    val resultado = texto?.firstOrNull() ?: "Sin dato"

    //Mostramos el resultado
    println("Resultado: $resultado")
}
fun exercise_24(){
    //Declaramos una variable String? (puede ser null)
    //Le asignamos inicialmente un valor NO nulo.
    var texto: String? = "Kotlin"

    //Usamos !!.length
    //El operador !! le dice al compilador: "confía en mí, esto NO es null".
    //Como texto contiene "Kotlin", no hay problema.
    println("Longitud inicial: ${texto!!.length}")   // Imprime: 6

    //Ahora cambiamos el valor a null
    texto = null

    //Volvemos a llamar a !!.length
    //Como texto AHORA es null, !! provoca una NullPointerException.
    //Esto hará que el programa falle en tiempo de ejecución.
    println("Longitud después de asignar null: ${texto!!.length}")  //ERROR
}
fun exercise_25(){
    //Declaramos una variable String? (puede ser null)
    var mensaje: String? = "Hola Kotlin"

    //Comprobamos si mensaje NO es null
    //Esta comprobación permite a Kotlin hacer *smart cast*:
    //Dentro del bloque 'if', mensaje se trata como String (no nullable).
    if (mensaje != null) {

        // Aquí mensaje ya NO es null, por lo que puede usarse directamente
        //    sin ?.length ni !!.length
        println("Longitud del mensaje: ${mensaje.length}")

    } else {

        //Si mensaje es null, mostramos un mensaje alternativo
        println("El mensaje es null, no tiene longitud.")
    }
}
fun exercise_26(){
    //Declaramos la lista original que contiene valores nulos.
    //Es una List<String?> porque cada elemento puede ser un String o null.
    val lista: List<String?> = listOf("Juan", null, "Ana", null, "Pablo")

    //Creamos una nueva lista mutable donde guardaremos SOLO los valores no nulos.
    val sinNulos = mutableListOf<String>()

    //Recorremos la lista original elemento por elemento.
    for (elemento in lista) {

        //Comprobamos si el elemento es distinto de null.
        //Si NO es null, gracias al smart cast, Kotlin lo tratará como String.
        if (elemento != null) {
            sinNulos.add(elemento)  // Añadimos el valor a la nueva lista
        }
    }

    //Mostramos ambas listas para comparar el resultado
    println("Lista original: $lista")
    println("Lista sin nulos: $sinNulos")
}
fun exercise_27(){
    //Pedimos un número al usuario
    println("Introduce un número:")

    //Leemos la entrada como String? (readLine() puede devolver null)
    //Después usamos toIntOrNull(), que intenta convertir:
    //       - Si es un número válido → devuelve Int
    //       - Si NO es válido       → devuelve null
    val numero: Int? = readLine()?.toIntOrNull()

    //Comprobamos si la conversión ha fallado
    //    Si numero es null → entrada no válida
    if (numero == null) {
        println("Entrada no válida.")
    } else {
        //Si NO es null → el número es válido y podemos usarlo con normalidad
        println("Has introducido el número: $numero")
    }
}
fun exercise_28(){
    //Lista original con valores Double? (algunos son null)
    val notas: List<Double?> = listOf(5.0, null, 7.5, 8.0, null, 6.5)

    //Variables para acumular la suma y contar cuántos valores NO nulos tenemos
    var suma = 0.0
    var contador = 0

    //Recorremos la lista elemento por elemento
    for (n in notas) {

        //Si el elemento NO es null, lo sumamos y aumentamos el contador
        if (n != null) {
            suma += n
            contador++
        }
    }

    //Calculamos la media solo si contador > 0 (evita división por cero)
    val media = if (contador > 0) suma / contador else 0.0

    //Mostramos el resultado
    println("Notas originales: $notas")
    println("Media sin valores nulos: $media")
}