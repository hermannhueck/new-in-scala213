package feature.collections.mapview

import scala.util.chaining._

import scala.collection.MapView

object MapView213 extends App {

    println("\n========== MapView 2.13")

    val kvs = Map("one" -> 1, "two" -> 2, "three" -> 3) tap println
    val kvsFlipped: Map[Int, String] = kvs.toList.map { case (fst, snd) => (snd, fst) }.toMap tap println

    ">>> mapValues:" tap println
    val mapView: MapView[String, Int] = kvs.mapValues(_ + 10) tap println
    val mappedValues: Map[String, Int] = mapView.toMap tap println

    ">>> filterKeys:" tap println
    val mapView2: MapView[Int, String] = kvsFlipped.filterKeys(_ %2 != 0) tap println
    val keysFiltered: Map[Int, String] = mapView2.toMap tap println

    println("==========\n")
}