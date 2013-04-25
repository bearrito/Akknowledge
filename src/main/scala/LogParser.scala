import scala.util.parsing.combinator.RegexParsers

/**
 * Created with IntelliJ IDEA.
 * User: bearrito
 * Date: 4/24/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */

case class Log(facility : Int, level : Int, message : String)

class LogParser extends RegexParsers {

  def facility : Parser[Int] = """[0-9]""".r^^{_.toInt}
  def level    = """[0-7]""".r^^{_.toInt}
  def message  = """.*""".r
  def sep = "," | "\t"
  def expr : Parser[Log] = {
    facility ~ sep ~ level ~sep~ message ^^ {
     case   facility ~ sep1 ~ level ~ sep2 ~ message => Log(facility,level,message)

   }




  }

}
