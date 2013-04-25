/**
 * Created with IntelliJ IDEA.
 * User: bearrito
 * Date: 4/24/13
 * Time: 10:43 PM
 * To change this template use File | Settings | File Templates.
 */


import akka.testkit._
import akka.actor._
import akka.pattern.ask
import akka.transactor.Coordinated
import com.typesafe.config.ConfigFactory

import org.scalatest._
import scala.concurrent.duration._
import scala.concurrent.Await


class LogParserSpecs extends FunSuite{

  test("Parses simple log") {
        val parser = new LogParser
        val parseResult = parser.parseAll(parser.expr,"0,1,Apr 24 23:03:36,valhall,logger:, masdasdd")
        val log = parseResult.get
        assert(log.facility == 0)


  }
}
