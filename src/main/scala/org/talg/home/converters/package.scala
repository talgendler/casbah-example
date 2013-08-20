package org.talg.home

import com.mongodb.MongoException

/**
 * User: talg
 */
package object converters {
  def mongoFail = throw new MongoException("Field not found, someone messed with the DB")
}
