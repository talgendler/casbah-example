package org.talg.home.dao

import org.talg.home.entities.Person
import org.talg.home.entities.PersonMongoProperties.ID
import com.mongodb.casbah.{MongoClient, MongoClientURI}
import org.talg.home.converters.PersonMongoConverter
import com.mongodb.casbah.Imports._

/**
 * User: talg
 */
object SimplePersonDao {
  /**
   * Mongo URI string [[http://docs.mongodb.org/manual/reference/connection-string/]]
   */
  private val uri = """mongodb://localhost:27017/"""
  val db = MongoClient(MongoClientURI(uri))( """casbah-test""")
  val collection = db("person")

  def insert(person: Person) = {
    collection.insert(PersonMongoConverter.convertToMongoObject(person))
  }

  def findOne(id: ObjectId) = {
    convertFromMongo(collection.findOne(MongoDBObject(ID -> id)))
  }
  
  def findByName(name :String) = {
    import org.talg.home.entities.PersonMongoProperties.NAME
    val query = MongoDBObject(NAME -> name)
    convertFromMongo(collection.findOne(query))
  }

  private def convertFromMongo(dbObj : Option[DBObject]) : Option[Person]= {
    dbObj match {
      case Some(x) => Some(PersonMongoConverter.convertFromMongoObject(x))
      case None => None
    }
  }
}
