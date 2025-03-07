package vendingmachine

fun main() {

    //val cokeSoda = Soda("Coke", 1.00, 12)

    //Map key-pairs to soda
    //check quantity before giving out soda
    //give change

    val vendingMachine = VendingMachine()

    val coke = Product("Coke", 1.00, 12.0)
    val pepsi= Product("Pepsi", 1.50, 12.0)
    val pokemonCardPack = Product("Pokemon Card Pack", 3.99, 10.0)
    vendingMachine.mapButtonToProduct("a1", coke)
    vendingMachine.restockProduct("Coke", 12.0)
    vendingMachine.mapButtonToProduct("a2", pepsi)
    vendingMachine.mapButtonToProduct("a3", pokemonCardPack)
/*    sodaInventory.addSoda(cokeSoda)
    sodaInventory.addSoda(pepsiSoda)*/
    //vendingMachine.insertMoney(0.0)
    //vendingMachine.insertMoney(-36789.0)
    vendingMachine.insertMoney(1.0)
    vendingMachine.pressButton("a1")
    vendingMachine.insertMoney(1.0)
    vendingMachine.insertMoney(1.0)
    vendingMachine.pressButton("a2")

}