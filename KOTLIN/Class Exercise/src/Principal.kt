// ---------------------------------------------------------
// PARTE 4. FUNCIÓN main() - POLIMORFISMO
// ---------------------------------------------------------
// Aquí demostramos:
//
// 1) Polimorfismo: una lista de Employee que contiene
//    Developer, Manager y Designer.
//
// 2) Llamadas a métodos abstractos sobrescritos:
//    work() y calculateAnnualBonus().
//
// 3) Uso de 'is Evaluable' para comprobar si un objeto
//    implementa la interfaz, y entonces llamar a
//    evaluatePerformance().
//
// 4) Smart cast en Kotlin: dentro del if (emp is Evaluable),
//    emp pasa a tratarse como Evaluable sin necesidad de cast manual.
//
fun main() {

    // Creamos una lista polimórfica de empleados
    val employees: List<Employee> = listOf(
        Developer("Alice", 30000.0),
        Manager("Bob", 50000.0),
        Designer("Carol", 35000.0)
    )

    // Recorremos la lista y llamamos a los métodos requeridos
    for (emp in employees) {
        println("-------------------------------------------------")

        // 1. Cada empleado realiza su trabajo específico
        emp.work()

        // 2. Mostramos detalles comunes (método de la superclase)
        emp.details()

        // 3. Calculamos e imprimimos el bonus anual
        val bonus = emp.calculateAnnualBonus()
        println("Annual bonus: $bonus")


        // 4. Si el empleado es Evaluable, evaluamos su rendimiento
        //    'is Evaluable' comprueba si este objeto implementa la interfaz
        if (emp is Evaluable) {
            // Gracias al smart cast, aquí emp se trata ya como Evaluable
            emp.evaluatePerformance()
            
        }

        println()
    }
}