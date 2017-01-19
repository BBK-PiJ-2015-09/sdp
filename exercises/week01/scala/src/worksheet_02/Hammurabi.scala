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
    printReport()
  }

  def printReport(): Unit = {
    var i = 0
    for(i <- 1 to 10) {
      println(
        s"""
          |O great Hammurabi!
          |You are in year $i of your ten year rule.
          |In the previous year 0 people starved to death.
          |In the previous year 5 people entered the kingdom.
          |The population is now 100.
          |We harvested 3000 bushels at 3 bushels per acre.
          |Rats destroyed 200 bushels, leaving 2800 bushels in storage.
          |The city owns 1000 acres of land.
          |Land is currently worth 19 bushels per acre.
          |There were 0 deaths from the plague.
        """.stripMargin
      )
    }
  }

  def printIntroductoryMessage(): Unit = {
    println(
      """
        |Congratulations, you are the newest ruler of ancient Samaria, elected
        |for a ten year term of office. Your duties are to dispense food, direct
        |farming, and buy and sell land as needed to support your people. Watch
        |out for rat infestations and the plague! Grain is the general currency,
        |measured in bushels. The following will help you in your decisions:
        |
        |  * Each person needs at least 20 bushels of grain per year to survive.
        |  * Each person can farm at most 10 acres of land.
        |  * It takes 2 bushels of grain to farm an acre of land.
        |  * The market price for land fluctuates yearly.
        |
        |Rule wisely and you will be showered with appreciation at the end of
        |your term. Rule poorly and you will be kicked out of office!
      """.stripMargin

    )
  }

}


