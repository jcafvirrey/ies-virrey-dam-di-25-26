fun main(){

    val temperature = Temperature()
    temperature.celsius = 98.6
    println(temperature.celsius)
    val bankAccount = BankAccount()
    bankAccount.balance = 152.6789
    println(bankAccount.balance)
    // Usando el constructor primario
    val p1 = Person("Ana", 25)
    p1.city = ""   // setter convertirá esto en "Unknown"
    p1.displayInfo()

    println("-----")

    // Usando el constructor secundario 1
    val p2 = Person("Luis", 30, "Madrid")
    p2.displayInfo()

    println("-----")

    // Usando el constructor secundario 2
    val p3 = Person("Mario")  // edad asignada por defecto = 0
    p3.displayInfo()
}