package org.talg.home.entities

/**
 * User: talg
 */
case class Person(
                   age: Int,
                   name: String,
                   address: Address,
                   knownLanguages: Set[String]
                   )

object PersonMongoProperties {
  val AGE = "age"
  val NAME = "name"
  val ADDRESS = "address"
  val KNOWN_LANGUAGES = "languages"
}