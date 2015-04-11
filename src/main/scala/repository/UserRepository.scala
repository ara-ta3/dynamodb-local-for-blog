package repository

import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec
import model.User
import db.{DynamoDB => mydb}

import scala.collection.JavaConversions._
import conversions.UserConversions._


case class UserRepository(private val db:DynamoDB) {

  def this() = this(mydb.db)

  private val tableName = "users"

  private val table = db.getTable(tableName)

  def findAll:Seq[User] =
    table.scan(new ScanSpec())
      .toSeq
      .map( i => new User(i.getInt(UserRepository.idKeyName), i.getString(UserRepository.nameKeyName)))

  def save(u:User):Unit = table.putItem(u)
}

object UserRepository {
  val idKeyName = "id"

  val nameKeyName = "name"
}
