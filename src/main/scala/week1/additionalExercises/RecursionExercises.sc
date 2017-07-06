package week1.additionalExercises

object RecursionExercises {
  
  def gcd(a: Int, b: Int) : Int = {
  		if(b == 0) a else gcd(b, a%b)
  }                                               //> gcd: (a: Int, b: Int)Int
  
  gcd(1,5)                                        //> res0: Int = 1
  gcd(10, 100)                                    //> res1: Int = 10
  
  //https://www.hackerrank.com/challenges/string-mingling/problem
  def mingle(p: String, q: String, acc: StringBuilder): StringBuilder = {
        if(p.isEmpty) acc
        else mingle(p.tail, q.tail, acc.append(p.head).append(q.head))
  }                                               //> mingle: (p: String, q: String, acc: StringBuilder)StringBuilder
  
  mingle("word1", "word2", StringBuilder.newBuilder)
                                                  //> res2: StringBuilder = wwoorrdd12
}