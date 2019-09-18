package feature.collections

import scala.util.chaining._

import scala.collection.MapView

object MapView213 extends App {

  println("\n========== MapView 2.13")

  val kvs = Map("one" -> 1, "two" -> 2, "three" -> 3) tap println

  val kvsFlipped
      : Map[Int, String] = kvs.toList.map { case (fst, snd) => (snd, fst) }.toMap tap println

  "\n>>> Map#mapValues returns MapView instead of Map and is deprecated in 2.13:" tap println
  // Map:  def mapValues[W](f: (V) => W): MapView[K, W]
  // Map#mapValues returns MapView instead of Map and is deprecated in 2.13
  val mapView: MapView[String, Int]  = kvs.view.mapValues(_ + 10) tap println
  val mappedValues: Map[String, Int] = mapView.toMap tap println

  "\n>>> Map#filterKeys returns MapView instead of Map and is deprecated in 2.13:" tap println
  // Map:  def filterKeys(p: (K) => Boolean): MapView[K, V]
  // Map#filterKeys returns MapView instead of Map and is deprecated in 2.13
  val mapView2: MapView[Int, String] = kvsFlipped.view.filterKeys(_ % 2 != 0) tap println
  val keysFiltered: Map[Int, String] = mapView2.toMap tap println

  println("==========\n")
}
