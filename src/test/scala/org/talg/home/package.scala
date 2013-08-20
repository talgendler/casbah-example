package org.talg

import org.talg.home.entities.{Person, Address}
import com.mongodb.casbah.Imports._

/**
 * User: talg
 */
package object home {
  def ADDRESS = Address(
    street = "Lombard",
    zipCode = 12345,
    city = "San Francisco",
    country = "United States"
  )

  def PERSON = Person(
    _id = new ObjectId,
    age = 99,
    name = "Moses",
    address = ADDRESS,
    knownLanguages = List("english", "hebrew", "russian"),
    socialId = Some(12345654321L)
  )
}

