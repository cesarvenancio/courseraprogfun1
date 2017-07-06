package week1

object tailRecursionSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(126); 

  def factorial(n: Double): Double =
    if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Double)Double""");$skip(285); 

  def tailFactorial(n: Double): Double = {
    def factorialWithAccumulator(accumulator: Double, number: Double): Double = {
      if (number == 1) return accumulator
      else factorialWithAccumulator(accumulator * number, number - 1);
    }

    factorialWithAccumulator(1, n)
  };System.out.println("""tailFactorial: (n: Double)Double""");$skip(16); val res$0 = 

  factorial(5);System.out.println("""res0: Double = """ + $show(res$0));$skip(19); val res$1 = 
  tailFactorial(5);System.out.println("""res1: Double = """ + $show(res$1))}
}
