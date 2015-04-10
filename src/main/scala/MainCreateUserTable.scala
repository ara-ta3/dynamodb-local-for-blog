import com.amazonaws.services.dynamodbv2.model._
import db.DynamoDB
import scala.collection.JavaConversions._

object MainCreateUserTable extends App{

  val tableName = "users"
  val keySchema:List[KeySchemaElement] = List(
    new KeySchemaElement().withAttributeName("id").withKeyType(KeyType.HASH)
  )
  val result = DynamoDB.client.createTable(
    new CreateTableRequest(tableName, keySchema)
      .withAttributeDefinitions(
        new AttributeDefinition().withAttributeName("id").withAttributeType(ScalarAttributeType.N)
      )
      .withProvisionedThroughput(
        new ProvisionedThroughput().withReadCapacityUnits(10l).withWriteCapacityUnits(5l)
      )
  )
  println(result)
}
