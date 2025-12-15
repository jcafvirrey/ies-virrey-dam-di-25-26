data class Product(
    val id: Int,
    val name: String,
    val price: Double
)

data class UiUser(
    val username: String,
    val isOnline: Boolean
)

enum class OrderStatus{
    CREATED,
    PAID,
    SENT,
    DELIVERED
}
enum class Priority(val level: Int) {
    LOW(1),
    MEDIUM(2),
    HIGH(3)
}

enum class AppTab {
    HOME,
    PROFILE,
    SETTINGS
}



