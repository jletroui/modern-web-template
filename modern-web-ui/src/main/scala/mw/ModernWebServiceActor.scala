package mw

import akka.actor.Actor
import spray.routing.HttpService
import spray.http._
import MediaTypes._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class ModernWebServiceActor extends Actor with ModernWebService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(route)
}

// this trait defines our service behavior independently from the service actor
trait ModernWebService extends HttpService {

  val route = {
    get {
      path("") {
        respondWithMediaType(`text/plain`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete("Hello")
        }
      }
    }
  }
}