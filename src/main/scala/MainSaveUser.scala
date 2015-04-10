import db.DynamoDB
import model.User

object MainSaveUser extends App {
  val mapper = DynamoDB.mapper
  val user:User = new User(1, "HogeName")
  mapper.save(user);
}
