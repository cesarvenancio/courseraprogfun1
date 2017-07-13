package week1.additionalExercises

import math.abs

object Week2FixedPoint {
  val tolerance = 0.0001;                         //> tolerance  : Double = 1.0E-4
  
  def isCloseEnough(x: Double, y: Double) =
    abs((x-y) / x) / x < tolerance                //> isCloseEnough: (x: Double, y: Double)Boolean
    
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
    		val next = f(guess)
    		if(isCloseEnough(guess, next)) next
    		else iterate(next)
    }
    
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  fixedPoint(x => 1 + x/2)(1)                     //> res0: Double = 1.999755859375
  
  //square root
  def sqrt(x: Double) = fixedPoint(y => (y+ x/y)/2) (1.0)
                                                  //> sqrt: (x: Double)Double
  
  sqrt(5)                                         //> res1: Double = 2.236067977499978
  
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  
  def sqrtAverageDamp(x: Double) =
    fixedPoint(averageDamp(y => x/y))(1)          //> sqrtAverageDamp: (x: Double)Double
    
  sqrtAverageDamp(5)                              //> res2: Double = 2.236067977499978
}