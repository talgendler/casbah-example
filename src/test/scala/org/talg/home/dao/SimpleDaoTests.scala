package org.talg.home.dao

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.talg.home._

/**
 * User: talg
 */
@RunWith(classOf[JUnitRunner])
class SimpleDaoTests extends FunSpec with ShouldMatchers {
  describe("save and find") {
    val person = PERSON
    it("should save a person to DB") {
      val result = SimplePersonDao.insert(person)

      assert(result.getLastError.ok())
      /* Should look like this (_id different)
          {
              "_id": ObjectId("5213bb7344aeccb377f9da51"),
              "name": "Moses",
              "age": NumberInt(99),
              "languages": {
                  "0": "english",
                  "1": "hebrew",
                  "2": "russian"
              },
              "address": {
                  "street": "Lombard",
                  "zip": NumberInt(12345),
                  "city": "San Francisco",
                  "country": "United States"
              },
              "socialId": NumberLong(12345654321)
          }
       */
    }
    it("should find that person by ID") {
      val found = SimplePersonDao.findOne(person._id)
      person should equal(found.get)
    }

    it("should find that person by name") {
      val found = (SimplePersonDao.findByName("Moses"))

      person should equal(found.get)
    }
  }

}
