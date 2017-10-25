package com.isuzuki.http4s.app

import java.util.concurrent.{ExecutorService, Executors}

import fs2.{Stream, Task}
import org.http4s.HttpService
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.util.StreamApp

import scala.concurrent.ExecutionContext

object AppRouter {
  val service = HttpService {
    case GET -> Root / "hello" =>
      Ok("Hello World")
  }
}

object Main extends StreamApp {
  private lazy val pool: ExecutorService = Executors.newCachedThreadPool()

  override def stream(args: List[String]): Stream[Task, Nothing] = {
    BlazeBuilder
      .bindHttp(8080, "0.0.0.0")
      .mountService(AppRouter.service, "/")
      .withExecutionContext(ExecutionContext.fromExecutorService(pool))
      .serve
  }
}