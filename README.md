# 🌐 CRUD operations with Spring Boot Java Framework

- Link to access the base API url
```
    localhost:8080/api/clients/
```

- Make sure you have a client for HTTP requests, like Insomnia or Postman
- Make sure you have Java 17 or later

# ⚙️ Using:
<div style="width: 50px; display: flex; gap: 20px; align-items: center">

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mongodb/mongodb-original.svg" />

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

# 🌳 Repository Tree (may be changed often)

```
.
├── build
│   ├── classes
│   │   └── java
│   │       └── main
│   │           └── com
│   │               └── gustavohnsv
│   │                   └── clients
│   │                       ├── ClientsApplication.class
│   │                       ├── config
│   │                       │   └── DotenvConfig.class
│   │                       ├── controller
│   │                       │   ├── ClientController.class
│   │                       │   ├── HomeController.class
│   │                       │   └── ShoppingCartsController.class
│   │                       ├── exception
│   │                       │   ├── AlreadyExistsException.class
│   │                       │   ├── CustomExceptionHandler.class
│   │                       │   ├── ResourceNotFoundException.class
│   │                       │   ├── TooFewArgumentsException.class
│   │                       │   └── WrongArgumentsException.class
│   │                       ├── model
│   │                       │   ├── Client.class
│   │                       │   ├── Message.class
│   │                       │   ├── Product.class
│   │                       │   └── ShoppingCart.class
│   │                       └── repository
│   │                           ├── ClientRepository.class
│   │                           └── ShoppingCartsRepository.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       └── main
│   │       └── headers
│   │           └── java
│   │               └── main
│   ├── resources
│   │   └── main
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── tmp
│       └── compileJava
│           ├── compileTransaction
│           │   ├── backup-dir
│           │   └── stash-dir
│           │       └── ShoppingCartsController.class.uniqueId0
│           └── previous-compilation-data.bin
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── HELP.md
├── README.md
├── settings.gradle
└── src
├── main
│   ├── java
│   │   └── com
│   │       └── gustavohnsv
│   │           └── clients
│   │               ├── ClientsApplication.java
│   │               ├── config
│   │               │   └── DotenvConfig.java
│   │               ├── controller
│   │               │   ├── ClientController.java
│   │               │   ├── HomeController.java
│   │               │   └── ShoppingCartsController.java
│   │               ├── exception
│   │               │   ├── AlreadyExistsException.java
│   │               │   ├── CustomExceptionHandler.java
│   │               │   ├── ResourceNotFoundException.java
│   │               │   ├── TooFewArgumentsException.java
│   │               │   └── WrongArgumentsException.java
│   │               ├── model
│   │               │   ├── Client.java
│   │               │   ├── Message.java
│   │               │   ├── Product.java
│   │               │   └── ShoppingCart.java
│   │               └── repository
│   │                   ├── ClientRepository.java
│   │                   └── ShoppingCartsRepository.java
│   └── resources
│       ├── application.properties
│       ├── static
│       └── templates
└── test
└── java
└── com
└── gustavohnsv
└── clients
└── ClientsApplicationTests.java
```