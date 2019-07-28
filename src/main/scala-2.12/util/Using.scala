package util

import scala.util.Try

import scala.language.reflectiveCalls

object Using {

  def apply[A, R <: {def close(): Unit}](resrc: R)(use: R => A): Try[A] =
    Try(resource(resrc)(use))

  def resource[A, R <: {def close(): Unit}](resrc: R)(use: R => A): A =
    try {
      use(resrc)
    } finally {
      resrc.close()
    }
}
