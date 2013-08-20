package org.talg.home.converters

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.talg.home.ADDRESS

/**
 * User: talg
 */
@RunWith(classOf[JUnitRunner])
class AddressMongoConverterTest extends FunSpec with ShouldMatchers {
  describe("Testing Address mongo converter") {
    it("should convert address to mongo and back") {
      val address = ADDRESS
      val dbObj = AddressMongoConverter convertToMongoObject address
      val converted = AddressMongoConverter convertFromMongoObject dbObj

      address should equal (converted)
    }
  }
}
