package vendingmachine

class VendingMachine {

    //helper function - below instance variable. mu
    //check quantity

    private var cashInMachine: Double = 100.0
    private var cashInserted: Double = 0.0

    private val buttonToPriceMap = mutableMapOf<String, Product>( //make mutableMap
        /*        "Coke" to 1.0,
                "Pepsi" to 1.50,
                "Sprite" to 1.0
                //KEY      VALUE*/
    )

    // Should this be rolled into restock function?
    fun mapButtonToProduct(buttonName: String, product: Product) {
        this.buttonToPriceMap[buttonName] = product
    }

    fun insertMoney(cash: Double) {
        if (cash <= 0.0) {
            throw IllegalArgumentException("cash must be > 0")
        }
        this.cashInserted += cash;
    }

    fun pressButton(buttonName: String) {
        // TODO: Check quantity of product in stock
        // If quantity is > 0, subtract 1 from stack
        // If quantity is < 0, throw error
        if (buttonToPriceMap[buttonName] !is Product) {
            throw IllegalArgumentException("vendingmachine.Product is not valid")
        }
        val product = buttonToPriceMap[buttonName]!!
        val price: Double = product.price
        val quantity = product.quantity

        if (quantity == 0.0) {
            println("Sorry. We are out of ${product.name}")
            throw IllegalStateException("vendingmachine.Product ${product.name} is out of stock")
        }

        if (cashInserted < price) {
            throw IllegalArgumentException("Not enough cash. Need ${price - cashInserted}.")
        }

        cashInMachine += cashInserted;
        product.quantity--
        println(product.quantity)

        val change = cashInserted - price;
        if (change > 0.0) {
            println("Thank You! Your change is $${change}.")
            cashInMachine -= change;
        } else {
            println("Thank You! ")
        }

        cashInserted = 0.0

        println("Here's your ${product.name} ")

    }

    // TODO: Create restock function
    // Check if product is in machine
    // Do we need to know button to product? Do we iterate over the map to find it?
    // If product is not in machine, does restock map it to the next available button?

    fun restockProduct(
        name : String,
        quantityToIncrease : Double) {

        if (!buttonToPriceMap.values.any { it.name == name }) {
            throw IllegalStateException("Item does not exist. restockProduct function")
        }
        val product = buttonToPriceMap.values.find { it.name == name }
        product?.quantity += quantityToIncrease
        println("Restocked $quantityToIncrease of ${product?.name}. New quantity: ${product?.quantity}")
    }

}




/*
class SodaMapping() {

    //Initialize empty list of Sodas
    private var sodaList : MutableMap<String, Double> = mutableMapOf()

    fun addSoda(
        soda : Soda) {
        //MAP String -> Double
                          //KEY    VALUE
        sodaList[soda.name] = soda.price
    }



}
*/

//displayProducts
//refund-
//digit pad
