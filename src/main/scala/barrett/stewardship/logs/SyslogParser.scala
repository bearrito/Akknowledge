package barrett.stewardship.logs

import scala.util.parsing.combinator.RegexParsers
import org.joda.time._
import org.joda.time.format.DateTimeFormat

/**
 * Created with IntelliJ IDEA.
 * User: bearrito
 * Date: 4/24/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */

case class Log(facility : Int, level : Int,time : DateTime, host : String, application : String, message : String)

class SyslogParser extends RegexParsers {



  def facility : Parser[Int] = """[0-9]""".r^^{_.toInt}
  def level    = """[0-7]""".r^^{_.toInt}
  def message  = """\w+""".r
  def date =    """[a-zA-Z]{3}\s[1-9]{2}\s\w{2}[:]\w{2}[:]\w{2}""".r
  def sep = "," | "\t"
  def host =   """\w+""".r
  def application   = """\w+:?""".r
  def expr : Parser[Log] = {
    facility ~ sep ~ level ~ sep ~ date ~ sep ~ host ~sep~ application ~ sep~  message ^^ {
     case   facility ~ sep1 ~ level ~ sep2 ~ date ~ sep4 ~ host ~sep3~ application ~ sep~  message  => {
       //val time = DateTimeFormat.forPattern("MMM dd HH:mm:ss").parseDateTime(date)
       Log(facility,level,DateTime.now(),host,application,message)
     }

   }




  }

}
