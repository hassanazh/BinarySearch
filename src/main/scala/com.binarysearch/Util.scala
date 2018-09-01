package com.binarysearch

import com.typesafe.scalalogging.LazyLogging

import scala.io.StdIn

trait Util extends LazyLogging {
  def addName(array: Array[String]): Array[String] = {
    print("Enter new name:")
    Some(StdIn.readLine()).foldLeft(array) { (a, newName) =>
      a :+ newName
    }.sorted
  }

  def inputName(namesArray: Array[String]): Unit = {
    print("Enter name to search:")
    val name = StdIn.readLine()
    logger.info(s"Index of $name is: ${findElementIndex(name, namesArray)}")
  }

  private def findElementIndex(element: String, array: Array[String], index: Int = 0): Long = {
    array.splitAt(array.length / 2) match {
      case (left, _) if left.lastOption.exists(_.compareTo(element) > 0) =>
        findElementIndex(element, left, index)
      case (left, right) if left.lastOption.exists(_.compareTo(element) < 0) =>
        findElementIndex(element, right, index + left.length)
      case (left, right) =>
        if (left.lastOption.contains(element)) {
          index + left.length - 1
        } else if (right.headOption.contains(element)) {
          index + right.length - 1
        } else {
          -1
        }
    }
  }
}
