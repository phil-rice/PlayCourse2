package services

import play.api.libs.ws.{WSClient, WSRequest, WSResponse}

import scala.concurrent.{ExecutionContext, Future}

case class IsUpRequest(url: String)


object IsUpRequest {

  implicit object BuildRequestForStatusRequest extends BuildRequestFrom[IsUpRequest] {
    override def apply(ws: WSClient)(t: IsUpRequest): WSRequest = ws.url(t.url)
  }

}

case class IsUpResult(url: String, up: Boolean)

object IsUpResult {

  implicit object BuildResponseForIsUpResult extends BuildFromResponse[IsUpRequest, IsUpResult] {
    override def status200(req: IsUpRequest, response: WSResponse) = IsUpResult(req.url, true)
    override def statusOther(req: IsUpRequest, response: WSResponse) =IsUpResult(req.url, true)
  }

}

class IsUpService(ws: WSClient)(implicit ex: ExecutionContext) extends HttpService[IsUpRequest, IsUpResult](ws)
