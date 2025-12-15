fun main(){
    ejercicio1()
    ejercicio2()
    ejercicio3()
    ejercicio4()
    ejercicio5()
    ejercicio6()
}
fun ejercicio1(){
    val product1 = Product(1, "Ratón", 15.99)
    val product2 = Product(1,"Ratón",15.99)
    println(product1 == product2)
    println(product1.equals(product2))
}
fun ejercicio2(){
    val originalProduct = Product(2, "Teclado", 29.99)

    val discountProduct  = originalProduct.copy(price = 19.99)

    println(originalProduct)
    println(discountProduct)
}
fun ejercicio3(){
    var user = UiUser("Ana", false)
    println("Estado inicial: $user")

    user = user.copy(isOnline = true)
    println("Estado actualizado: $user")
}
fun ejercicio4(){
    val status = OrderStatus.SENT

    val message = when(status){
        OrderStatus.CREATED -> "Pedido creado: aún no se ha pagado"
        OrderStatus.PAID -> "Pedido pagado: preparando envío"
        OrderStatus.SENT -> "Pedido enviado: en mi camino"
        OrderStatus.DELIVERED -> "Pedido entregado: finalizado"
    }
    println(message)
}

fun ejercicio5() {
    val p = Priority.HIGH

    println("Prioridad: $p")
    println("Nivel numérico: ${p.level}")
}
fun ejercicio6(){
    val currentTab = AppTab.PROFILE
    showTab(currentTab)
}
fun showTab(tab: AppTab) {
    when (tab) {
        AppTab.HOME -> println("Pantalla Inicio: noticias y contenido principal.")
        AppTab.PROFILE -> println("Pantalla Perfil: datos del usuario.")
        AppTab.SETTINGS -> println("Pantalla Ajustes: configuración de la app.")
    }
}