package computerdatabase
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
class MicronautSimulation extends Simulation {
  val httpConf = http
    .baseURL("http://localhost:8080") // Here is the root for all relative URLs
    .acceptHeader("application/json") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("ja,en-US;q=0.7,en;q=0.3")
   //.acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0")

  val scn = scenario("test")
    .exec(http("request")
      .get("/func"))
    .pause(100 milliseconds)

  setUp(scn.inject(rampUsers(500) over(10 seconds)) .protocols(httpConf))

}