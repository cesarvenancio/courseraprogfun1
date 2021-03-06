package week1.additionalExercises

object RecursionExercises {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(139); 

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  };System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(13); val res$0 = 

  gcd(1, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  gcd(10, 100);System.out.println("""res1: Int = """ + $show(res$1));$skip(235); 

  //https://www.hackerrank.com/challenges/string-mingling/problem
  def mingle(p: String, q: String, acc: StringBuilder): StringBuilder = {
    if (p.isEmpty) acc
    else mingle(p.tail, q.tail, acc.append(p.head).append(q.head))
  };System.out.println("""mingle: (p: String, q: String, acc: StringBuilder)StringBuilder""");$skip(54); val res$2 = 

  mingle("word1", "word2", StringBuilder.newBuilder);System.out.println("""res2: StringBuilder = """ + $show(res$2));$skip(191); 
                                                  

  //https://www.hackerrank.com/challenges/fp-filter-array
  def filterArray(delim: Int, arr: List[Int]): List[Int] = arr.filter(_ < delim);System.out.println("""filterArray: (delim: Int, arr: List[Int])List[Int]""");$skip(248); 
                                                  
  
  //https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers/
  def fibonacci(x:Int):Int = if (x < 3) x - 1 else fibonacci(x - 1) + fibonacci(x - 2);System.out.println("""fibonacci: (x: Int)Int""");$skip(231); 
                                                  

  //https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list
  def filterIndexPosition(arr: List[Int]): List[Int] = arr.zipWithIndex.filter(_._2 % 2 == 1).map { _._1 };System.out.println("""filterIndexPosition: (arr: List[Int])List[Int]""");$skip(181); 
                                                 

  //https://www.hackerrank.com/challenges/fp-array-of-n-elements
  def createArrayRange(num: Int): List[Int] = List.range(0, num);System.out.println("""createArrayRange: (num: Int)List[Int]""");$skip(171); 
                                                  

  //https://www.hackerrank.com/challenges/fp-reverse-a-list
  def reverseList(arr: List[Int]): List[Int] = arr.reverse;System.out.println("""reverseList: (arr: List[Int])List[Int]""");$skip(188); 
                                                  
  
  //https://www.hackerrank.com/challenges/fp-sum-of-odd-elements
  def sumOddElements(arr:List[Int]):Int = arr.filter(_ % 2 != 0).sum;System.out.println("""sumOddElements: (arr: List[Int])Int""");$skip(160); 
                                                  
  
  //https://www.hackerrank.com/challenges/fp-list-length
  def listLength(arr:List[Int]):Int = arr.length;System.out.println("""listLength: (arr: List[Int])Int""");$skip(116); 
  
  //https://www.hackerrank.com/challenges/fp-update-list
  def f(arr:List[Int]):List[Int] = arr.map(Math.abs(_));System.out.println("""f: (arr: List[Int])List[Int]""");$skip(156); 
                                                  
   def product(f: Int => Int) (a:Int, b:Int): Int =
    if(a > b) 1
    else f(a) * product (f) (a+1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(31); val res$3 = 
    
  product(x => x*x) (3,7);System.out.println("""res3: Int = """ + $show(res$3));$skip(57); 
  
  def factorialProduct(n: Int) = product(x => x)(1,n);System.out.println("""factorialProduct: (n: Int)Int""");$skip(22); val res$4 = 
  factorialProduct(5);System.out.println("""res4: Int = """ + $show(res$4));$skip(181); 
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a:Int, b:Int): Int = {
    if(a > b) zero
    else combine(f(a), mapReduce(f, combine, zero) (a+1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(98); 
    
  def productReduce(f: Int => Int) (a:Int, b:Int): Int = mapReduce(f, (x,y) => x*y, 1) (a,b);System.out.println("""productReduce: (f: Int => Int)(a: Int, b: Int)Int""");$skip(89); 
  def sumReduce(f: Int => Int) (a:Int, b:Int): Int = mapReduce(f, (x,y) => x+y, 0) (a,b);System.out.println("""sumReduce: (f: Int => Int)(a: Int, b: Int)Int""");$skip(67); 
  
  def factorialReduce(n: Int): Int = productReduce(x => x)(1,n);System.out.println("""factorialReduce: (n: Int)Int""");$skip(21); val res$5 = 
  factorialReduce(5);System.out.println("""res5: Int = """ + $show(res$5));$skip(26); val res$6 = 
  sumReduce(x => x) (2,5);System.out.println("""res6: Int = """ + $show(res$6))}
}
