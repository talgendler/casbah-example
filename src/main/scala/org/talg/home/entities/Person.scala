package org.talg.home.entities

import org.bson.types.ObjectId

/**
 * User: talg
 */
case class Person(
  _id : ObjectId,
                   age: Int,
                   name: String,
                   address: Address,
                   knownLanguages: Seq[String],
                   socialId: Option[Long]
                   )

object PersonMongoProperties {
  val ID = "_id"
  val AGE = "age"
  val NAME = "name"
  val ADDRESS = "address"
  val KNOWN_LANGUAGES = "languages"
  val SOCIAL_ID = "socialId"
}