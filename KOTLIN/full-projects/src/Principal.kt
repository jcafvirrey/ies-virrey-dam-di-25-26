fun main() {

    // -----------------------------------------------------------
    // 1. Crear objetos de cada tipo
    // -----------------------------------------------------------
    val product = Product("Ratón inalámbrico", 15.99)
    val laptop = Laptop("Dell Inspiron", 750.0, 16)
    val smartphone1 = Smartphone("Samsung Galaxy", 299.99, 128)
    val smartphone2 = Smartphone("Nokia 3310") // usa constructor secundario

    // -----------------------------------------------------------
    // 2. Modificar precios (uso setter personalizado)
    // -----------------------------------------------------------
    laptop.price = -100.0   // Intento incorrecto
    smartphone1.price = 349.95

    // -----------------------------------------------------------
    // 3. Mostrar resultados
    // -----------------------------------------------------------
    product.showDetails()
    laptop.showDetails()
    smartphone1.showDetails()
    smartphone2.showDetails()
}