package week1

object tailRecursionSession {

 def factorial(n: Double): Double =
  	if(n == 0) 1 else n * factorial(n-1)      //> factorial: (n: Double)Double

  def tailFactorial(n: Double): Double = {
  	def factorialWithAccumulator(accumulator: Double, number: Double): Double = {
  		if(number == 1) return accumulator
  		else factorialWithAccumulator(accumulator * number, number-1);
  	}
  
  	factorialWithAccumulator(1, n)
  }                                               //> tailFactorial: (n: Double)Double
  
  factorial(5)                                    //> res0: Double = 120.0
  tailFactorial(5)                                //> res1: Double = 120.0
}