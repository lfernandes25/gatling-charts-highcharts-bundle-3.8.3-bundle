import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Gatling extends Simulation {

  val httpProtocol = http
    .baseUrl("https://gatling.io")
    .inferHtmlResources()
    .silentResources

  val scn = scenario("Gatling Simulation")
    .exec(
      http("Home").get("/"))
    .exec(
      http("Open Source").get("/open-source"))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}