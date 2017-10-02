package services

import scala.concurrent.{ExecutionContext, Future}

trait RecoverFrom[Res] {
  def apply: PartialFunction[Throwable, Future[Res]]
}

class ErrorService[Req, Res](delegate: Req => Future[Res])(implicit recoverFrom: RecoverFrom[Res], ec: ExecutionContext) extends (Req => Future[Res]) {
  override def apply(v1: Req) = delegate(v1).recoverWith(recoverFrom.apply)
}
