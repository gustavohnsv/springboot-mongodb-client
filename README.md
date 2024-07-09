# 🌐 CRUD operations with Spring Boot Java Framework

- Link to access the base API url:
```
    localhost:8080/api/clients/
```

- If you want test the application in your localhost, make sure to make a Cluster in mongoDB and follow this steps:

1. Make a `.env` file in root folder *(/clients)*

2. In the file, insert this line:
```
    MONGODB_URI=your-mongodb-uri
```

- Make sure you have a client for HTTP requests, like Insomnia or Postman
- Make sure you have Java 17 or later
- This project use Gradle

# ⚙️ Using
<div style="display: flex; gap: 20px; align-items: center">

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mongodb/mongodb-original.svg" width="50"/>

</div>

# 📶 Endpoints

```
    GET     localhost:8080/api/
    GET     localhost:8080/api/clients/
    GET     localhost:8080/api/carts/
    GET     localhost:8080/api/clients/{id}
    GET     localhost:8080/api/carts/{cart_id}
    POST    localhost:8080/api/clients/
    POST    localhost:8080/api/carts/?id={owner_id}
    POST    localhost:8080/api/carts/{cartID}/
    PATCH   localhost:8080/api/clients/?id={id}
    PUT     localhost:8080/api/carts/{cart_id}/
    DELETE  localhost:8080/api/clients/?id={id}
    DELETE  localhost:8080/api/carts/?id={cart_id}
    DELETE  localhost:8080/api/carts/{cart_id}/
```

# 🌳 Repository Tree (maybe changed often)

```
.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── HELP.md
├── README.md
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── gustavohnsv
    │   │           └── clients
    │   │               ├── ClientsApplication.java
    │   │               ├── config
    │   │               │   └── DotenvConfig.java
    │   │               ├── controller
    │   │               │   ├── ClientController.java
    │   │               │   ├── HomeController.java
    │   │               │   └── ShoppingCartsController.java
    │   │               ├── exception
    │   │               │   ├── CustomExceptionHandler.java
    │   │               │   ├── ResourceAlreadyExistsException.java
    │   │               │   ├── ResourceNotFoundException.java
    │   │               │   ├── TooFewArgumentsException.java
    │   │               │   └── WrongArgumentsException.java
    │   │               ├── model
    │   │               │   ├── Client.java
    │   │               │   ├── Message.java
    │   │               │   ├── ProductInfo.java
    │   │               │   ├── Product.java
    │   │               │   └── ShoppingCart.java
    │   │               └── repository
    │   │                   ├── ClientRepository.java
    │   │                   └── ShoppingCartsRepository.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── gustavohnsv
                    └── clients
                        └── ClientsApplicationTests.java

```
