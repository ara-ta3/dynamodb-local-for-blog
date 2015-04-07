import db.DynamoDB
import model.User

object MainSaveUser extends App {
  val mapper = DynamoDB.mapper
  val user:User = new User(1.toString, "HogeName")
  mapper.save(user);
}
