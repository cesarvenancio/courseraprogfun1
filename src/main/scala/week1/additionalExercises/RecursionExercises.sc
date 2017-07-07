package week1.additionalExercises

object RecursionExercises {

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }                                               //> gcd: (a: Int, b: Int)Int

  gcd(1, 5)                                       //> res0: Int = 1
  gcd(10, 100)                                    //> res1: Int = 10

  //https://www.hackerrank.com/challenges/string-mingling/problem
  def mingle(p: String, q: String, acc: StringBuilder): StringBuilder = {
    if (p.isEmpty) acc
    else mingle(p.tail, q.tail, acc.append(p.head).append(q.head))
  }                                               //> mingle: (p: String, q: String, acc: StringBuilder)StringBuilder

  mingle("word1", "word2", StringBuilder.newBuilder)
                                                  //> res2: StringBuilder = wwoorrdd12
                                                  

  //https://www.hackerrank.com/challenges/fp-filter-array
  def filterArray(delim: Int, arr: List[Int]): List[Int] = arr.filter(_ < delim)
                                                  //> filterArray: (delim: Int, arr: List[Int])List[Int]
                                                  
  
  //https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers/
  def fibonacci(x:Int):Int = if (x < 3) x - 1 else fibonacci(x - 1) + fibonacci(x - 2)
                                                  //> fibonacci: (x: Int)Int
                                                  

  //https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list
  def filterIndexPosition(arr: List[Int]): List[Int] = arr.zipWithIndex.filter(_._2 % 2 == 1).map { _._1 }
                                                  //> filterIndexPosition: (arr: List[Int])List[Int]
                                                 

  //https://www.hackerrank.com/challenges/fp-array-of-n-elements
  def createArrayRange(num: Int): List[Int] = List.range(0, num)
                                                  //> createArrayRange: (num: Int)List[Int]
                                                  

  //https://www.hackerrank.com/challenges/fp-reverse-a-list
  def reverseList(arr: List[Int]): List[Int] = arr.reverse
                                                  //> reverseList: (arr: List[Int])List[Int]
                                                  
  
  //https://www.hackerrank.com/challenges/fp-sum-of-odd-elements
  def sumOddElements(arr:List[Int]):Int = arr.filter(_ % 2 != 0).sum
                                                  //> sumOddElements: (arr: List[Int])Int
                                                  
  
  //https://www.hackerrank.com/challenges/fp-list-length
  def listLength(arr:List[Int]):Int = arr.length  //> listLength: (arr: List[Int])Int
  
  //https://www.hackerrank.com/challenges/fp-update-list
  def f(arr:List[Int]):List[Int] = arr.map(Math.abs(_))
                                                  //> f: (arr: List[Int])List[Int]
}