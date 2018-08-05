package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else  {
      println("Computing factorial of " + n + " - I firs need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computing factorial of " + n)

      result
    }

  //println(factorial(5))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // tail recursion

    factorialHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factorialHelper(10, 1)
    = factorialHelper(9, 10 * 1)
    = factorialHelper(8, 9 * 10 * 1)
    = factorialHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factorialHelper(2, 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
    = factorialHelper(1, 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10)
   */

  println(anotherFactorial(5000))

  // when you need loops, use tail recursion

  /*
  1. Concatenate a string n times
  2. IsPrime function tail recursive
  3. Fibonacci function, tail recursive
   */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if(n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if(n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8))
}
