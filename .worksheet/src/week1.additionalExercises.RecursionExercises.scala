package week1.additionalExercises

object RecursionExercises {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(139); 
  
  def gcd(a: Int, b: Int) : Int = {
  		if(b == 0) a else gcd(b, a%b)
  };System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(14); val res$0 = 
  
  gcd(1,5);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  gcd(10, 100);System.out.println("""res1: Int = """ + $show(res$1));$skip(244); 
  
  //https://www.hackerrank.com/challenges/string-mingling/problem
  def mingle(p: String, q: String, acc: StringBuilder): StringBuilder = {
        if(p.isEmpty) acc
        else mingle(p.tail, q.tail, acc.append(p.head).append(q.head))
  };System.out.println("""mingle: (p: String, q: String, acc: StringBuilder)StringBuilder""");$skip(56); val res$2 = 
  
  mingle("word1", "word2", StringBuilder.newBuilder);System.out.println("""res2: StringBuilder = """ + $show(res$2))}
}
