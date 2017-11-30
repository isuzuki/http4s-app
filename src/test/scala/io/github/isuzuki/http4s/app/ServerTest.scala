package io.github.isuzuki.http4s.app

import org.http4s.{Method, Request}
import org.http4s.dsl._
import org.scalatest.{Matchers, WordSpec}

class ServerTest extends WordSpec with Matchers {
  "AppRouter" can {
    "acccess hello path" should {
      "return response status code 200" in {
        val request = Request(Method.GET, uri("hello"))
        val response = AppRouter.service.run(request).unsafeRunSync.right.get
        response.orNotFound.status.code shouldBe 200
      }
    }
  }
}
