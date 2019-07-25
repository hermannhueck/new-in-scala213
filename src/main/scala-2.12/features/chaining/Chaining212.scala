package features.chaining

object Chaining212 extends App {

    println("\n========== Chaining 2.12")

    {
        val x = 5
        println(x)

        val y = 5 * x
        println(y)
    }

    println("-----")

    {
        implicit class ChainigOps[A](a: A) {
            def pipe[B](f: A => B): B = f(a)
            def |>[B](f: A => B): B = a pipe f
            def tap[B](f: A => Unit): A = a pipe ( x => { f(x); x } )
        }

        val x: Int = 5 tap println

        val y: Int = 5 pipe (_ * x) tap println
        val z: Int = 5 |> (_ * x) tap println
    }

    println("==========\n")
}