package com.isuzuki.http4s

import org.slf4j.{Logger, LoggerFactory}

package object app {
  lazy val appLogger: Logger = LoggerFactory.getLogger("com.isuzuki.http4s.app.AppLogger")
}