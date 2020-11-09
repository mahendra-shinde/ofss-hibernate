## Creating a Maven project

1.  Launch eclipse or spring toolsuite with a new workspace.
2.  File -> New Project -> Maven Project
3.  Maven project properties

    ```yml
    Skip Archetype Selection : Simple Project
    GroupId:    Reverse Domain of Organization / Base package
    ArtifactId: Project Name
    Name:       Project Name (Use by eclipse)
    Version:    1.0
    Packaging:  Jar
    ```

4.  After project is created, locate "pom.xml" file and add these lines before the closing "project" tag.
    
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
			<version>5.4.10.Final</version>
		</dependency>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.22</version>
        </dependency>

	</dependencies>
    ```

5.  Eclipse should now, start downloading all dependencies. Wait for 4-5 minutes.
