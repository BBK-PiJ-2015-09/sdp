import scala.io.StdIn.readLine
import scala.util.control.Breaks._
import scala.util.Random

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

    var endGame = false
    var totalStarved = 0

    printIntroductoryMessage()

    var i = 0
    breakable {
      for(i <- 1 to 10) {
        if (endGame) break
        println(
          s"""
             |O great Hammurabi!
             |You are in year $i of your ten year rule.
             |In the previous year $starved people starved to death.
             |In the previous year $immigrants people entered the kingdom.
             |The population is now $population.
             |We harvested $harvest bushels at $bushelsPerAcre bushels per acre.
             |Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.
             |The city owns $acresOwned acres of land.
             |Land is currently worth $pricePerAcre bushels per acre.
             |There were $plagueDeaths deaths from the plague.
          """.stripMargin
        )

        // Collect user input.
        var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
        acresOwned = acresOwned + acresToBuy
        bushelsInStorage = bushelsInStorage - (acresToBuy * pricePerAcre)

        if (acresToBuy == 0) {
          var acresToSell = askHowMuchLandToSell(acresOwned)
          acresOwned = acresOwned - acresToSell
          bushelsInStorage = bushelsInStorage + (acresToSell * pricePerAcre)
        }

        var grainToFeed = askHowMuchGrainToFeed(bushelsInStorage)
        bushelsInStorage = bushelsInStorage - grainToFeed

        var acresToPlant = askHowManyAcresToPlant(acresOwned)

        // Determine consequences.
        if (random(15)) {
          plagueDeaths = population / 2
          population = population - plagueDeaths
          println("Oh no! A terrible plague has afflicted the city!")
        } else {
          plagueDeaths = 0
        }

        var grainNeeded = population * 20
        if (grainToFeed > grainNeeded) {
          var waste = grainToFeed - grainNeeded
          println(waste + " bushels of grain were wasted!")
        } else if (grainToFeed < grainNeeded) {
          var shortfall = grainNeeded - grainToFeed
          var starved = shortfall / 20
          population = population - starved
          totalStarved = totalStarved + starved
          println("Oh no! There was not enough grain and " + starved + " people starved!")
          var starvationCap = (population / 20) * 9
          if (starved > starvationCap) {
            println("Too many people starved! You are thrown out of office :( GAME OVER")
            endGame = true
          }
        }

        if (grainToFeed >= grainNeeded) {
          immigrants = (20 * acresOwned + bushelsInStorage) / (100 * population) + 1
        } else {
          immigrants = 0
        }
        population = population + immigrants

        var yieldInt =  Random.nextInt(8) + 1
        println("yieldInt is: " + yieldInt)
        bushelsPerAcre = yieldInt
        harvest = acresToPlant * bushelsPerAcre
        bushelsInStorage = bushelsInStorage + harvest

        if (random(40)) {
          rats_ate = (bushelsInStorage / 10) * (Random.nextInt(3) + 1)
          bushelsInStorage = bushelsInStorage - rats_ate
        }

        pricePerAcre = Random.nextInt(23) + 17

      }
    }

    printSummary(totalStarved, acresOwned)

  }

  def askHowMuchLandToBuy(bushels: Int, price: Int) = {
    var acresToBuy = readInt("How many acres will you buy? ")
    while (acresToBuy < 0 || acresToBuy * price > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      acresToBuy = readInt("How many acres will you buy?? ")
    }
    acresToBuy
  }

  def askHowMuchLandToSell(acres: Int) = {
    var acresToSell = readInt("How many acres will you sell? ")
    while (acresToSell < 0 || acresToSell > acres) {
      println("O Great Hammurabi, we have but " + acres + " acres of land!")
      acresToSell = readInt("How many acres will you sell?? ")
    }
    acresToSell
  }

  def askHowMuchGrainToFeed(bushels: Int) = {
    var grainToFeed = readInt("How much grain will you feed to the people? ")
    while (grainToFeed < 0 || grainToFeed > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      grainToFeed = readInt("How much grain will you feed to the people?? ")
    }
    grainToFeed
  }

  def askHowManyAcresToPlant(acres: Int) = {
    var acresToPlant = readInt("How many acres will you plant with seed? ")
    while (acresToPlant < 0 || acresToPlant > acres) {
      println("O Great Hammurabi, we have but " + acres + " acres of land!")
      acresToPlant = readInt("How many acres will you plant with seed?? ")
    }
    acresToPlant
  }

  def random(chance: Int) = {
    if (Random.nextInt(100) < chance) {
      true
    } else {
      false
    }
  }

  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _: Throwable =>
        println("That’s not an integer. Please enter an integer.")
        readInt(message)
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

  def printSummary(starved: Int, acres: Int): Unit = {
    println("Congratulations, you survived! " + starved + " people starved, and ")
    println("you owned " + acres + " acres of land by the end of the game!")
    println("****~~~~GAME OVER~~~~****")
  }

}


