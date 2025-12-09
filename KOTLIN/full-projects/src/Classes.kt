// -----------------------------------------------------------
// SUPERCLASE Product
// -----------------------------------------------------------

// Esta clase representa un producto genérico.
// Clase base
// que será heredada por otras más específicas.
open class Product(
    val name: String,        // Propiedad inmutable
    price: Double            // price se inicializa a través del setter
) {

    // -----------------------------------------------------------
    // PROPIEDAD price CON SETTER PERSONALIZADO
    // -----------------------------------------------------------
    // El setter debe validar datos.
    // El setter usa 'field', que es el campo de respaldo (backing field).
    // Permite demostrar la diferencia entre 'field'
    // y la propiedad en sí.
    var price: Double = price
        set(value) {
            field = if (value >= 0) value else 0.0
        }

    // -----------------------------------------------------------
    // PROPIEDAD CALCULADA info (solo lectura)
    // -----------------------------------------------------------
    // Se usa como ejemplo de propiedad derivada: no almacena datos,
    // solo devuelve un resultado calculado cada vez.
    val info: String
        get() = "Producto: $name - Precio: %.2f €".format(price)

    // -----------------------------------------------------------
    // MÉTODO showDetails
    // -----------------------------------------------------------
    // Método simple para mostrar la información del producto.
    open fun showDetails() {
        println(info)
    }
}

// -----------------------------------------------------------
// SUBCLASE Laptop
// -----------------------------------------------------------

// Hereda de Product usando el constructor primario.
// Este ejemplo ayuda a comprender cómo una subclase debe llamar
// al constructor padre con los parámetros requeridos.
class Laptop(
    name: String,
    price: Double,
    val ramGB: Int
) : Product(name, price) {

    // -----------------------------------------------------------
    // Sobrescritura (override) del método showDetails()
    // -----------------------------------------------------------
    // Se muestra cómo modificar el comportamiento de una función heredada.
    override fun showDetails() {
        println("Laptop: $name - Precio: %.2f € - RAM: ${ramGB}GB".format(price))
    }
}
// -----------------------------------------------------------
// SUBCLASE Smartphone
// -----------------------------------------------------------

// Este ejemplo combina:
// - Constructor primario
// - Constructor secundario
// - Herencia
// - Mensajes que se ejecutan durante la construcción
class Smartphone(
    name: String,
    price: Double,
    val storage: Int
) : Product(name, price) {

    // -----------------------------------------------------------
    // CONSTRUCTOR SECUNDARIO
    // -----------------------------------------------------------
    // Aprende el alumnado:
    // - Cómo usar un constructor secundario correctamente.
    // - Cómo llamar al primario.
    // - Cómo proporcionar valores por defecto.
    constructor(name: String) : this(name, 0.0, 64) {
        println("Precio no proporcionado. Almacenamiento por defecto: 64 GB")
    }

    // -----------------------------------------------------------
    // Sobrescritura del método showDetails()
    // -----------------------------------------------------------
    override fun showDetails() {
        println("Smartphone: $name - Precio: %.2f € - Storage: ${storage}GB".format(price))
    }
}