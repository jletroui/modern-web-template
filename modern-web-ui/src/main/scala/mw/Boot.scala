package mw

import spray.routing.{RequestContext, SimpleRoutingApp}
import spray.httpx.marshalling.BasicMarshallers._
import spray.util._
import spray.http._
import spray.can.server.SprayCanHttpServerApp
import akka.actor.Props

/**
 *
 */
object Boot extends App with SprayCanHttpServerApp {

  // create and start our service actor
  val service = system.actorOf(Props[ModernWebServiceActor], "modern-web")

  // create a new HttpServer using our handler and tell it where to bind to
  newHttpServer(service) ! Bind(interface = "localhost", port = 8080)
}