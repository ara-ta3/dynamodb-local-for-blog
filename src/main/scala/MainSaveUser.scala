import db.DynamoDB
import model.User
import repository.UserRepository

object MainSaveUser extends App {
  val mapper = DynamoDB.mapper
  val user:User = new User(1, "HogeName")
  mapper.save(user);

  val repository = new UserRepository
  val usersByRepository = repository.save(new User(2, "FugaName"))
}
