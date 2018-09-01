package com.binarysearch

import scala.io.StdIn

object BinarySearch extends App with Util {
  private val arr = Array("Andreas", "Aun", "David", "Felix", "Hassan", "Ingwar", "Jacek", "Manual", "Salim", "Wacek", "Zara")

  logger.info(s"Size of the name array is: ${arr.length}")

  inputName(arr)
  print("Do you want to add more names in array? (y/n):")
  val newArray = StdIn.readChar() match {
    case 'Y' | 'y' => addName(arr)
    case _ => arr
  }

  print("Do you want to search a name again? (y/n)")
  StdIn.readChar() match {
    case 'Y' | 'y' => inputName(newArray)
    case _ => logger.info("Thank you!")
  }
}