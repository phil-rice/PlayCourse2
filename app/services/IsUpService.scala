package services

import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}

case class IsUpRequest(url: String)

case class IsUpResult(url: String, up: Boolean)

//class IsUpService(ws: WSClient)(implicit ex: ExecutionContext) extends (IsUpRequest => Future[IsUpResult]) {
//  override def apply(req: IsUpRequest) = {
//    ws.url(req.url).execute().map(wsResponse => wsResponse.status match {
//      case 200 => IsUpResult(req.url, true)
//      case _ => IsUpResult(req.url, false)
//    }).fallbackTo { case _ => Future.successful(IsUpResult(req.url, false)) }
//  }
//}

