package week3

object intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : week3.NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : week3.IntSet = """ + $show(t2 ));$skip(21); 
  val t3 = t2 incl 6;System.out.println("""t3  : week3.IntSet = """ + $show(t3 ));$skip(18); val res$0 = 
  
  t1.union(t3);System.out.println("""res0: week3.IntSet = """ + $show(res$0));$skip(54); val res$1 = 
  
  new NonEmpty(7, new Empty, new Empty) contains 7;System.out.println("""res1: Boolean = """ + $show(res$1))}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {

  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def union(other: IntSet): IntSet = {
		((left union right) union other) incl elem
  }

  override def toString = "{" + left + elem + right + "}"

}
