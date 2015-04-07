package db

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper

object DynamoDB {
  private val provider = new DefaultAWSCredentialsProviderChain()
  private val configuration = new com.amazonaws.ClientConfiguration() {
    override def getMaxErrorRetry: Int = 0
    override def getConnectionTimeout: Int = 1000
  }

  private val client:AmazonDynamoDBClient = new AmazonDynamoDBClient(provider.getCredentials, configuration)
  client.setEndpoint("http://localhost:8000", "", "ap-northeast-1");

  val mapper:DynamoDBMapper = new DynamoDBMapper(client);
}
