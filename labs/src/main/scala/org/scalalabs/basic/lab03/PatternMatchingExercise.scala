package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to the powerful pattern matching features of Scala.
 *
 * Pattern matching can in its essence be compared to Java's 'switch' statement,
 * even though it provides many more possibilites. Whereas the Java switch statmenet
 * lets you 'match' primitive types up to int's, Scala's pattern matching goes much
 * further. Practically everything from all types of objects and Collections
 * can be matched, not forgetting xml and a special type of class called case classes.
 *
 * Pattern matching is also often used in combination with recursive algorithms.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the
 * corresponding unit test work.
 */

object PatternMatchingExercise {

  /*************************************************************************
   *  pattern matching exercises
   * For expected solution see unittest @PatternMatchingExerciseTest
   *************************************************************************/

  def describeLanguage(s: String): String = {
    s match {
      case "Java" | "Smalltalk" => "OOP"
      case "Clojure" | "Haskell" => "Functional"
      case "Scala" => "Hybrid"
      case "C" => "Procedural"
      case  _  => "Unknown"
    }
  }

  /**
   * Here's how matches should work. If `in` is:
   * 
   *    - a `String`, the function result is "A string with length n"
   *       where `n` is the length of `in`
   *       
   *    - a positive `Integer`, the function result is "A positive integer"
   *    
   *    - an instance of class `Person`, the function result is "A person with name: n"
   *       where `n` is the name of the person
   *       
   *    - a sequence with more than 10 elements, the function result is "Seq with more than 10 elements"
   *    
   *    - a sequence with at least three elements, the function result is "first: v1, second: v2, rest: tail"
   *        where v1, v2, and tail are the corresponding values from the sequence
   *        
   *    - null, the function result is "A null value"
   *        
   *    - anything else, the function result is "Some Scala class"
   */
  
// I checked my solution against the given solution to find the errors in my code and modified it accordingly.
  def matchOnInputType(in: Any) = in match {
      case word: String => s"A string with length ${word.length}"
      case i: Int if i > 0 => "A positive integer"
      case p @ Person(name,_) => s"A person with name: ${name}"
      case l: Seq[_] if l.length > 10 => "Seq with more than 10 elements"
      case first::second::tail => s"first: ${first}, second: ${second}, rest: ${tail}"
      case null => "A null value"
      case _ => "Some Scala class"
  }

  /**
   * If the person is older than 30, return an `Option` with the person's name;
   *    otherwise return `None`
   */
  def older(p: Person): Option[String] = {
    p match {
      case p1 @ Person(name,age) if age > 30 => Some(name)
      case  _  => None
    }
  }
}

case class Person(name: String, age: Int)