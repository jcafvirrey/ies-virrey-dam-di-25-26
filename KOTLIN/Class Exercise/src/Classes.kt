// ---------------------------------------------------------
// PARTE 1. CLASE ABSTRACTA Employee
// ---------------------------------------------------------
// Representa un empleado genérico de la empresa.
// No se puede instanciar directamente porque es abstracta.
// Define qué datos mínimos tiene cualquier empleado
// y qué métodos deben implementar las subclases.
abstract class Employee(
    val name: String,   // Nombre del empleado (solo lectura)
    val salary: Double  // Salario mensual o anual (depende de cómo lo interpretemos)
) {

    // Método abstracto: cada tipo de empleado debe definir
    // qué trabajo realiza exactamente.
    abstract fun work()

    // Método abstracto: cada tipo de empleado calcula su bonus
    // de forma distinta, por eso no se implementa aquí.
    abstract fun calculateAnnualBonus(): Double

    // Método concreto: se hereda tal cual en las subclases.
    // Muestra por pantalla los datos básicos del empleado.
    fun details() {
        println("Employee: $name - Salary: $salary")
    }
}


// ---------------------------------------------------------
// PARTE 2. INTERFAZ Evaluable
// ---------------------------------------------------------
// Una interfaz define un "contrato" de comportamiento.
// En este caso, cualquier clase que implemente Evaluable
// tendrá el método evaluatePerformance().
//
// En Kotlin podemos dar una implementación por defecto.
// Esto es muy útil para no repetir el mismo código en todas
// las clases que implementen la interfaz.
interface Evaluable {

    // Implementación genérica por defecto.
    // Las clases que lo deseen pueden sobrescribirlo.
    fun evaluatePerformance() {
        println("Performance evaluation: Meets expectations.")
    }
}


// ---------------------------------------------------------
// PARTE 3. CLASES DERIVADAS DE Employee
// ---------------------------------------------------------
// Cada una representa un tipo concreto de empleado.
// Todas:
//  - heredan de Employee
//  - implementan los métodos abstractos work() y calculateAnnualBonus()
//  - además implementan Evaluable para poder ser evaluadas
//    (esto nos permitirá usar el 'is Evaluable' en main()).
// ---------------------------------------------------------


// ------------------------
// 3.1 Developer
// ------------------------
class Developer(
    name: String,
    salary: Double
) : Employee(name, salary), Evaluable {

    // Implementación específica del trabajo del desarrollador
    override fun work() {
        println("$name: Writing and reviewing code.")
    }

    // El bonus anual es el 10% del salario
    override fun calculateAnnualBonus(): Double {
        return salary * 0.10
    }

    // Opcionalmente podríamos sobrescribir evaluatePerformance()
    // para un mensaje específico. Si no lo hacemos, usará el genérico
    // de la interfaz Evaluable.
    // override fun evaluatePerformance() { ... }
}


// ------------------------
// 3.2 Manager
// ------------------------
class Manager(
    name: String,
    salary: Double
) : Employee(name, salary), Evaluable {

    override fun work() {
        println("$name: Supervising the team and planning projects.")
    }

    // Bonus anual = 20% del salario
    override fun calculateAnnualBonus(): Double {
        return salary * 0.20
    }

    // Aquí mostramos cómo personalizar el mensaje de evaluación
    override fun evaluatePerformance() {
        println("Performance evaluation for Manager $name: Exceeds expectations.")
    }
}


// ------------------------
// 3.3 Designer
// ------------------------
class Designer(
    name: String,
    salary: Double
) : Employee(name, salary), Evaluable {

    override fun work() {
        println("$name: Creating and optimizing visual design.")
    }

    // Bonus anual = 15% del salario
    override fun calculateAnnualBonus(): Double {
        return salary * 0.15
    }

    // Usamos el mensaje genérico de la interfaz Evaluable,
    // pero también podríamos sobrescribirlo.
}
