fun main(){

}
//Exercise_29
// Función sin parámetros y sin valor de retorno (Unit)
fun saludar() {
    // Mostramos un mensaje fijo por consola
    println("Hola desde Kotlin")
}
//Exercise_30
// Función que recibe un parámetro obligatorio 'nombre'
fun mostrarNombre(nombre: String) {
    // Usamos interpolación de cadenas para construir el mensaje
    println("Tu nombre es: $nombre")
}

//Exercise_31
//Función que recibe un Int y devuelve su cuadrado como Int
fun cuadrado(n: Int): Int {
    // Calculamos el cuadrado
    val resultado = n * n

    // Devolvemos el valor calculado
    return resultado
}

//Exercise_32
// Versión compacta de la función cuadrado usando "expression body"
// No hace falta usar la palabra return ni llaves
fun cuadrado2(n: Int) = n * n

//Exercise_33
// Función con parámetro con valor por defecto.
// Si no se pasa un nombre, se usará "Invitado".
fun saludar(nombre: String = "Invitado") {
    println("Bienvenido, $nombre")
}

//Exercise_34
// 'activo' tiene valor por defecto true.
// Si no se indica nada, el usuario se considera activo.
fun crearUsuario(nombre: String, activo: Boolean = true) {

    // Elegimos el texto del estado en función del parámetro
    val estado = if (activo) "activo" else "desactivado"

    println("Usuario: $nombre ($estado)")
}

//Exercise_35
// Función con tres parámetros requeridos
fun mostrarDatos(nombre: String, edad: Int, ciudad: String) {
    println("Nombre: $nombre")
    println("Edad: $edad")
    println("Ciudad: $ciudad")
}

//Exercise_36
// 'iva' y 'descuento' tienen valores por defecto
// iva por defecto 21% y sin descuento por defecto
fun calcularPrecio(base: Double, iva: Double = 21.0, descuento: Double = 0.0): Double {

    // 1) Calculamos el importe del IVA
    val cantidadIva = base * (iva / 100)

    // 2) Sumamos IVA al precio base
    val precioConIva = base + cantidadIva

    // 3) Calculamos el importe del descuento
    val cantidadDescuento = precioConIva * (descuento / 100)

    // 4) Restamos el descuento
    val precioFinal = precioConIva - cantidadDescuento

    return precioFinal
}

//Exercise_37
// 'nombre' y 'stock' son obligatorios.
// 'categoria' y 'activo' tienen valor por defecto.
fun registrarProducto(
    nombre: String,
    categoria: String = "General",
    stock: Int,
    activo: Boolean = true
) {
    val estado = if (activo) "activo" else "inactivo"

    println("Producto registrado:")
    println(" - Nombre: $nombre")
    println(" - Categoría: $categoria")
    println(" - Stock: $stock")
    println(" - Estado: $estado")
}

//Exercise_38
// Función compacta: el tipo de retorno se infiere (Double)
// 'altura' por defecto toma el mismo valor que 'base' → se comporta como un cuadrado.
fun areaRectangulo(base: Double, altura: Double = base) = base * altura
