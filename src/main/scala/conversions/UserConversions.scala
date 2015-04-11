package conversions

import com.amazonaws.services.dynamodbv2.document.Item
import model.User
import repository.UserRepository

object UserConversions {
  implicit def userToItem(u:User):Item =
    new Item()
      .withPrimaryKey(UserRepository.idKeyName, u.getId)
      .withString(UserRepository.nameKeyName, u.getName)
}
