# Hibernate project flow

1.  Create a maven project
2.  Add hibernate and database dependencies in `pom.xml`

    ```xml
    <properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>


	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.3.1.Final</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.22</version>
		</dependency>

	</dependencies>
    ```

3.  Add the `hibernate.properties` file under `src/main/resources`

    ```ini
    hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver
    hibernate.connection.url=jdbc:mysql://localhost:3306/sample
    hibernate.connection.username=root
    hibernate.connection.password=pass@12345

    hibernate.connection.pool_size=5

    hibernate.show_sql=true
    hibernate.format_sql=true

    ## Hibernate to GENERATE NEW TABLE SCHEMA
    hibernate.hbm2ddl.auto=create
    ```

3.  Create the Entity classes.

4.  Create the `MySessionFactory`


5.  