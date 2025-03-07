package vendingmachine

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VendingMachineTest {

    val underTest = VendingMachine()

    @Test
    fun `insertMoney - happy path`() {
        Assertions.assertDoesNotThrow { underTest.insertMoney(1.0) }
    }

    @Test
    fun `insertMoney - less than 0`() {
        val result = Assertions.assertThrows(IllegalArgumentException::class.java) {
            underTest.insertMoney(-1.0)
        }
        Assertions.assertEquals("cash must be > 0", result.message)
    }



    @Test
    fun `pressButton - happy path`() {
        val cash = 1.0;
        Assertions.assertDoesNotThrow {
            underTest.insertMoney(cash)
            underTest.pressButton("Coke")
        }
    }

    @Test
    fun `pressButton - button does not exist`() {
        val result = Assertions.assertThrows(IllegalArgumentException::class.java) {
            underTest.pressButton("Dr.Pepper")
        }
        Assertions.assertEquals("Input is not valid", result.message)

    }

    @Test
    fun `pressButton - Button Not enough cash`() {
        val  cash = 0.5
        val result = Assertions.assertThrows(IllegalArgumentException::class.java) {
            underTest.insertMoney(cash)
            underTest.pressButton("Coke")
        }
        Assertions.assertEquals("Not enough cash. Need 0.5.", result.message)
    }



}