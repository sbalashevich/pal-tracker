##Flyway integration with Spring Boot

Spring boot application can automatically verify if DB schema is up-to-date, and run flyway migration scripts if there are new migration instructions. 

### Dependencies

First of all following dependencies should be added to `build.gradle` file:

    compile "org.flywaydb:flyway-core:4.2.0"
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-data-jpa', version: '1.5.9.RELEASE'
    compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.13'

`starter-data-jpa` and `mysql-connector-java` are required for DataSource autoconfiguration.

### Local configuration

For local configuration the information about MySQL instance should be provided manually. Let's create `application.properties` file in `scr/main/resources/` folder with the following content:

	spring.datasource.url= jdbc:mysql://localhost:3306/tracker_test
	spring.datasource.username= root
	spring.datasource.password=
	
>
>### Notice
>Correct username and password should be provided. 

### Migration files location
According to the flyway naming conventions the "migration files" should be located in `src/main/resources/db/migration/` folder.

let's copy the `databases/tracker/migrations/V1__initial_schema.sql` to the newly created `src/main/resources/db/migration/` folder. 

### Run application local
Now you can run application locally using:

	./gradlew bootRun
	
### Deploy to Cloud Foundry
Or deploy it to the cloud foundry:

	./gradlew clean build
	cf push