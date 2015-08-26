## Test project to reproduce issue spring-cloud/spring-cloud-config#217

### How to setup

1. Install RabbitMQ
2. Run config-server

  ```
  cd config-server
  ./gradlew clean bootrun
  ```
3. Run sample-app

  ```
  cd sample-app
  ./gradlew clean bootrun
  ```
4. Test
  
  ```
  $ curl -s -X GET http://localhost:8080/sample/test | python -m json.tool
  {
      "error": "Internal Server Error",
      "exception": "org.springframework.context.NoSuchMessageException",
      "message": "No message found under code 'my.message' for locale 'en'.",
      "path": "/sample/test",
      "status": 500,
      "timestamp": 1440606341144
  }
  ```
