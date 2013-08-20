package org.talg.home.converters

import org.talg.home.entities.Person
import com.mongodb.casbah.Imports._
import org.talg.home.entities.PersonMongoProperties._

/**
 * User: talg
 */
object PersonMongoConverter {
  def convertToMongoObject(person: Person): DBObject = {
    val builder = MongoDBObject.newBuilder
    builder += ID -> person._id
    builder += NAME -> person.name
    builder += AGE -> person.age
    builder += KNOWN_LANGUAGES -> MongoDBList(person.knownLanguages: _*)
    builder += ADDRESS -> AddressMongoConverter.convertToMongoObject(person.address)
    builder += SOCIAL_ID -> person.socialId // Pay attention this is an Option
    builder.result()
  }

  def convertFromMongoObject(db: DBObject): Person = {
    val name: String = db.getAsOrElse[String](NAME, mongoFail)
    val age: Int = db.getAsOrElse[Int](AGE, mongoFail)
    val knownLanguages = db.getAs[MongoDBList](KNOWN_LANGUAGES) match {
      case Some(languages) => languages collect {
        case s: String => s
      }
      case None => mongoFail
    }

    val socialId = db.getAs[Long](SOCIAL_ID)
    val address = AddressMongoConverter.convertFromMongoObject(db.getAsOrElse[DBObject](ADDRESS, mongoFail))

    Person(
      _id = db.getAsOrElse[ObjectId](ID, mongoFail),
      age = age,
      name = name,
      address = address,
      knownLanguages = knownLanguages,
      socialId = socialId
    )
  }
}
