import com.amazonaws.services.dynamodbv2.datamodeling.{DynamoDBScanExpression}
import db.DynamoDB
import model.User
import repository.UserRepository
import scala.collection.JavaConversions._

object MainLoadUser extends App {

  val mapper = DynamoDB.mapper
  val users = mapper.scan(classOf[User], new DynamoDBScanExpression)
  users.foreach(println(_))

  val repository = new UserRepository
  val usersByRepository = repository.findAll
  usersByRepository.foreach(println)
}
