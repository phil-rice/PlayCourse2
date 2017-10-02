package controllers

import javax.inject.{Inject, Singleton}

import play.api.libs.ws.WSClient
import play.api.mvc.{Action, Controller}
import services._

import scala.concurrent.ExecutionContext


@Singleton
class IsUpController @Inject()(wsClient: WSClient)(implicit ec: ExecutionContext) extends Controller {

  val isItUpService = new IsUpService(wsClient)

//  def isGoogleUp = Action.async { implicit request =>
//    isItUpService(IsUpRequest("http://www.google.com")).map { isUpResponse =>
//      if (isUpResponse.up) Ok("Google is Up") else BadGateway("Google is Down")
//    }
//  }
}
