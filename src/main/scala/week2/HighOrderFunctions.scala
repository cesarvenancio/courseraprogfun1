package week2

class HighOrderFunctions {
  
  def value(x: Int): Int = x
  def cube(x: Int): Int = x*x*x
  def fact(x: Int): Int = if(x == 0) 1 else x + fact(x-1)
    
  def sum(f: Int => Int, a: Int, b:Int): Int = 
    if(a > b) 0
    else f(a) + sum(f, a + 1, b)
    
  def sumInts(a: Int, b: Int): Int = sum(value, a, b)
  def sumCubes(a:Int, b: Int): Int = sum(cube, a, b)
  def sumFactorials(a: Int, b: Int): Int = sum(fact,a,b)

  //Using anonymous function
  
  def sumIntsAnonymous(a: Int, b: Int): Int = sum(x => x,a,b)
  def sumCubesAnonymous(a: Int, b: Int): Int = sum(x => x*x*x,a,b)
  
  def sumTail(f: Int => Int, a: Int, b:Int): Int = {
    def loop(a: Int, acc: Int): Int = 
      if(a > b) acc
      else loop(a+1, f(a) + acc)
    loop(a, 0)
  }
  
  sumTail(x => x*x,3,5)
  
  //Curryng
  
  def sumCurryng(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
       if(a > b) 0
       else f(a) + sumF(a+1,b)
    sumF
  }
  
  def sumCurryng2(f: Int => Int) (a: Int, b: Int): Int = {
    if(a > b) 0 else f(a) + sumCurryng2 (f) (a+1,b)
  }
  
  def sumInt = sumCurryng(x =>x)
  def sumCube = sumCurryng(x => x*x*x)
  def sumFactorial = sumCurryng(fact)
  
  sumCube(1, 10) + sumFactorial(10,20)
  
  sumCurryng (cube) (1, 10)
  sumCurryng (x => x*x*x) (1, 10)
  
  def product(f: Int => Int) (a:Int, b:Int): Int =
    if(a > b) 1
    else f(a) * product (f) (a+1, b)
    
  product(x => x*x) (3,7)
  
  def factorialProduct(n: Int) = product(x => x)(1,n)
  factorialProduct(5)
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a:Int, b:Int): Int = {
    if(a > b) zero
    else combine(f(a), mapReduce(f, combine, zero) (a+1, b))
  }
    
  def productReduce(f: Int => Int) (a:Int, b:Int): Int = mapReduce(f, (x,y) => x*y, 1) (a,b)
  def sumReduce(f: Int => Int) (a:Int, b:Int): Int = mapReduce(f, (x,y) => x+y, 0) (a,b)
  
  def factorialReduce(n: Int): Int = productReduce(x => x)(1,n)
  
  factorialReduce(5)                              
  sumReduce(x => x) (2,5)
}