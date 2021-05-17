package mock

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class CatsKarateSimulation extends Simulation {

  //MockUtils.startServer()

// val feeder = Iterator.continually(Map("catName" -> MockUtils.getNextCatName))

  val protocol = karateProtocol(
   
  )

 // protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")

  val create = scenario("create").exec(karateFeature("classpath:mock/PerfGatling.feature"))

  setUp(
    create.inject(rampUsers(2) during (5 seconds)).protocols(protocol)
    //create.inject(atOnceUsers(10)).protocols(protocol)
  )

}