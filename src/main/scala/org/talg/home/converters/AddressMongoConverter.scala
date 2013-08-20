package org.talg.home.converters

import org.talg.home.entities.Address
import org.talg.home.entities.AddressMongoProperties._
import com.mongodb.casbah.Imports._
import org.talg.home.entities

/**
 * User: talg
 */
object AddressMongoConverter {
  def convertToMongoObject(address: Address): DBObject = {
    /*
    Let's do it differently this time without a builder
     */
    MongoDBObject(
      STREET -> address.street,
      ZIP_CODE -> address.zipCode,
      CITY -> address.city,
      COUNTRY -> address.country
    )
  }

  def convertFromMongoObject(db: DBObject): Address = {
    entities.Address(
      street = db.getAsOrElse[String](STREET, mongoFail),
      zipCode = db.getAsOrElse[Int](ZIP_CODE, mongoFail),
      city = db.getAsOrElse[String](CITY, "Tel-Aviv"), // slightly different get
      country = db.getAsOrElse[String](COUNTRY, "Israel")
    )
  }
}
