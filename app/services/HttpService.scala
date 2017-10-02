package services

import play.api.libs.ws._

import scala.concurrent.{ExecutionContext, Future}

trait BuildRequestFrom[Req] {
  def apply(ws: WSClient)(t: Req): WSRequest
}

trait BuildFromResponse[Req, Res] {
  def apply(req: Req)(response: WSResponse): Res = response.status match {
    case 200 => status200(req, response)
    case x => statusOther(req, response)
  }
  def status200(req: Req, response: WSResponse): Res
  def statusOther(req: Req, response: WSResponse): Res
}

class HttpService[Req, Res](ws: WSClient)(implicit ex: ExecutionContext, buildRequest: BuildRequestFrom[Req], buildFromResponse: BuildFromResponse[Req, Res]) extends (Req => Future[Res]) {
  val makeRequest = buildRequest(ws) _

  override def apply(req: Req): Future[Res] = makeRequest(req).execute().map(buildFromResponse(req))
}
