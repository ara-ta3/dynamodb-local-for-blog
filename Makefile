dynamodb-start:
	java -Djava.library.path=./dynamodb/DynamoDBLocal_lib -jar ./dynamodb/DynamoDBLocal.jar [options]

dynamodb-setup:
	make setup -C dynamodb
