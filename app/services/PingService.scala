package services

import play.api.mvc.{AnyContent, Request, Result, Results}
import utilties.BuildResponseForPlay

import scala.concurrent.Future


trait PingRequest

object PingRequest extends PingRequest


trait PingResponse

object PingResponse extends PingResponse {

  implicit object BuildResponseFromPing extends BuildResponseForPlay[PingResponse] with Results {
    override def apply(t: PingResponse)(implicit request: Request[AnyContent]): Result = {
      Ok("pong").as("text/plain")
    }
  }

}

class PingService extends (PingRequest => PingResponse) {
  override def apply(req: PingRequest) = PingResponse
}