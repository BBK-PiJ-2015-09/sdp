object Hammurabi extends App {

  hammurabi()

  def hammurabi(): Unit = {
    var starved = 0 // how many people starved
    var immigrants = 5 // how many people came to the city
    var population = 100
    var harvest = 3000 // total bushels harvested
    var bushelsPerAcre = 3 // amount harvested for each acre planted
    var rats_ate = 200 // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19 // each acre costs this many bushels
    var plagueDeaths = 0

    printIntroductoryMessage()
  }

  def printIntroductoryMessage(): Unit = {
    println(
      """
        Congratulations, you are the newest ruler of ancient Samaria, elected
        for a ten year term of office. Your duties are to dispense food, direct
        farming, and buy and sell land as needed to support your people. Watch
        out for rat infestations and the plague! Grain is the general currency,
        measured in bushels. The following will help you in your decisions:

          * Each person needs at least 20 bushels of grain per year to survive.
          * Each person can farm at most 10 acres of land.
          * It takes 2 bushels of grain to farm an acre of land.
          * The market price for land fluctuates yearly.

        Rule wisely and you will be showered with appreciation at the end of
        your term. Rule poorly and you will be kicked out of office!
      """.stripMargin

    )
  }

}


