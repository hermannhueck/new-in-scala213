package features.chaining

object Chaining212 extends App {

    println("\n========== Chaining 2.12")

    {
        val x: Int = 5
        println(x)

        val y: Int = 5 * x
        println(y)

        val z = Some(5).map(_ * x).map(v => {println(v); v})
        println(z.get)
    }

    println("-----")

    {
        implicit class ChainingOps[A](a: A) {
            def pipe[B](f: A => B): B = f(a)
            def |>[B](f: A => B): B = a pipe f
            def tap[B](f: A => Unit): A = a pipe ( x => { f(x); x } )
        }

        val x: Int = 5 tap println

        val y: Int = 5 pipe (_ * x) tap println
        val z: Int = 5 |> (_ * x) tap println

        List(1, 2, 3) tap (ys => println("debug: " + ys.toString))

        val times6 = (_: Int) * 6
        (1 - 2 - 3) pipe times6 pipe scala.math.abs tap println
    }

    println("==========\n")
}