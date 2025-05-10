fun main() {


}

fun calculateCommission(
    cardType: String = "VK Pay",
    amount: Int,
    previousTransfers: Int = 0
): Int {
    val dailyLimit = 150_000
    val monthlyLimit = 600_000

    val total = previousTransfers + amount
    if (amount > dailyLimit || total > monthlyLimit) return -1 // превышен лимит

    return when (cardType) {
        "VK Pay" -> 0
        "Mastercard", "Maestro" ->
            if (amount in 300..75_000) 0
            else (amount * 0.006 + 20).toInt()
        "Visa", "Mir" ->
            maxOf((amount * 0.0075).toInt(), 35)
        else -> -1
    }
}
