package org.talg.home.entities

/**
 * User: talg
 */
case class Address(
               street: String,
               zipCode: Int,
               city: String,
               country: String
               )

object AddressMongoProperties {
  val STREET = "street"
  val ZIP_CODE = "zip"
  val CITY = "city"
  val COUNTRY = "country"
}