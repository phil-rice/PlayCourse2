package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import services.PingResponse.BuildResponseFromPing.Ok
import services.{PingRequest, PingResponse, PingService}
import status._

@Singleton
class PingController @Inject() extends Controller {

  def ping = Action { implicit request =>
    Ok("pong").as("text/plain")
  }


}
