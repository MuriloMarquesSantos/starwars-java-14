# Places Manager
This project was created to study Java 11 and 14 features such as Records and new HttpClient implementation

### Tools

This project was developed using the following technologies:
- **Java 14;**
- **Spring Boot;**
- **Maven**;

## Package Structure

# Requirements / Dependencies
- [Java 14](https://www.java.com/pt_BR/download/)
- [Maven](https://maven.apache.org/) to manage the project's build, reporting and documentation from a central piece of information;
- [Spring boot](https://spring.io/projects/spring-boot) for project setup and run;

Some Java 14 features are still in preview so you might need to activate it in your compiler.

If you are using maven to add the below code into your pom.xml

```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <release>14</release>
                <compilerArgs>--enable-preview</compilerArgs>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M3</version>
            <configuration>
                <argLine>--enable-preview</argLine>
            </configuration>
        </plugin>
    </plugins>
 </build>
 ```

# Running the application locally

  ### With Maven  

- Run the command below to compile the project  

```
$ mvn clean install
```

- You can run it with the command below. If you are using modern IDEs such as IntelliJ and Spring Tool Suite, they have built-in spring-boot startup tools.

```
$ mvn spring-boot:run
```

## API Call example

```http://localhost:8080/people/1```

Response: ``` {
    "name": "Luke Skywalker",
    "height": "172",
    "hair_color": "blond",
    "skin_color": "fair",
    "birth_year": "19BBY",
    "gender": "male"
} ```


### Contributors

- Murilo M. Santos <murilommms@gmail.com>

---


## Support

* If you have any query or doubt, please, feel free to contact me by e-mail.
