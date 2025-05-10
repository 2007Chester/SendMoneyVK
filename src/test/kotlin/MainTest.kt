import org.junit.Assert.*
import org.junit.Test

class MainTest {
    @Test
    fun notCommissionVK() {
        val result = calculateCommission("VK Pay", 1000)
        assertEquals(0, result)
    }

    @Test
    fun commissionVisa() {
        val result = calculateCommission("Visa", 100_000)
        assertEquals(750, result) // 0.75%
    }

    @Test
    fun minCommissionVisa() {
        val result = calculateCommission("Visa", 100)
        assertEquals(35, result) // минимум
    }

    @Test
    fun freeLimitMastercard() {
        val result = calculateCommission("Mastercard", 5000)
        assertEquals(0, result)
    }

    @Test
    fun fullCommissionMastercard() {
        val result = calculateCommission("Mastercard", 100_000)
        assertEquals(621, result) // 100000 * 0.006 + 20
    }

    @Test
    fun overDayLimit() {
        val result = calculateCommission("VK Pay", 160_000)
        assertEquals(-1, result)
    }

    @Test
    fun unknownCard() {
        val result = calculateCommission("Amex", 1000)
        assertEquals(-1, result)
    }

}