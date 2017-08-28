package com.isuzuki.http4s.app

import java.util.concurrent.{ExecutorService, Executors}

import org.http4s.HttpService
import org.http4s.dsl._
import org.http4s.server.{Server, ServerApp}
import org.http4s.server.blaze.BlazeBuilder

import scalaz.concurrent.Task

object AppRouter {
  val service = HttpService {
    case req @ GET -> Root / "hello" =>
      Ok("Hello World")
  }
}

object Main extends ServerApp {
  private lazy val pool: ExecutorService = Executors.newCachedThreadPool()

  override def server(args: List[String]): Task[Server] = {
    BlazeBuilder
      .bindHttp(8080, "0.0.0.0")
      .mountService(AppRouter.service, "/")
      .withServiceExecutor(pool)
      .start
  }
}