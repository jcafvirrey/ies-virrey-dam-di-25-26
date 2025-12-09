//Example Setter-Getter 1
class BankAccount {

    // Balance almacenado. El valor real siempre se guarda aquí en "field".
    var balance: Double = 0.0
        get() {
            // Getter: transforma el valor antes de devolverlo.
            // Mostramos siempre el balance redondeado a 2 decimales.

            return String.format("%.2f", field).toDouble()
        }
        set(value) {
            // Setter: valida y modifica antes de almacenar.
            // Si el valor es negativo, no lo guardamos: field se queda en 0.0
            field = if (value >= 0) value else 0.0
        }
}
//Example Setter-Getter 2
class Temperature {

    // Propiedad almacenada siempre en Celsius
    var celsius: Double = 0.0
        get() {
            // El getter devuelve directamente el valor almacenado
            return field
        }
        set(value) {
            // El setter interpreta 'value' como Fahrenheit,
            // lo convierte a Celsius y lo almacena en 'field'
            field = (value - 32) * 5/9
        }
}
//Example Full Class
class Person(val name: String, var age: Int) {

    // -------------------------------------------------------
    // PROPIEDAD city CON GETTER Y SETTER PERSONALIZADOS
    // -------------------------------------------------------
    // city almacena internamente el valor en 'field'.
    // El getter simplemente devuelve ese valor almacenado.
    // El setter valida si el texto está vacío.
    // Si está vacío, se guarda el valor "Unknown".
    var city: String = "Unknown"
        get() {
            // Getter personalizado: devolvemos el valor del campo 'field'
            // (esto es lo que realmente está almacenado internamente).
            return field
        }
        set(value) {
            // Setter personalizado: comprobamos si el texto recibido es vacío.
            // Si es vacío, sustituimos por "Unknown".
            // Si no, asignamos el valor recibido.
            field = if (value.isNotEmpty()) value else "Unknown"
            //equivalente field = value?:"Unknow"
        }


    // -------------------------------------------------------
    // CONSTRUCTOR SECUNDARIO 1
    // -------------------------------------------------------
    // Recibe nombre, edad y ciudad.
    // Llama al constructor primario con this(name, age)
    // y luego asigna la ciudad usando la propiedad city (invocando su setter).
    constructor(name: String, age: Int, city: String) : this(name, age) {
        this.city = city  // aquí se ejecuta el setter personalizado
    }


    // -------------------------------------------------------
    // CONSTRUCTOR SECUNDARIO 2
    // -------------------------------------------------------
    // Recibe SOLO el nombre.
    // Llama al constructor primario asignando la edad = 0 por defecto.
    // Después muestra un mensaje informativo.
    constructor(name: String) : this(name, 0) {
        println("La edad no se proporcionó. Se ha asignado 0 por defecto.")
    }


    // -------------------------------------------------------
    // MÉTODO displayInfo()
    // -------------------------------------------------------
    // Muestra toda la información de la persona de forma ordenada.
    fun displayInfo() {
        println("Nombre: $name")
        println("Edad: $age")
        println("Ciudad: $city")
    }
}