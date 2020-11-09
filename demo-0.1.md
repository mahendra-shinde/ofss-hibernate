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
			<version>5.2.13.Final</version>
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

6.  Launch MYSQL Workbench, and after connecting, run following SQL Query

    ```sql
    CREATE SCHEMA Sample;
    Use Sample;

    CREATE table products
    (
        productId int primary key,
        pname varchar(25),
        price float
    );

    INSERT into products VALUES(101, 'Product X' , 12000);
    INSERT into products VALUES(102, 'Product Y' , 8000);
    ```

7.  Switch back to the project in IDE. and create a new FILE 'hibernate.properties' inside
    `src/main/resources/`

    ```ini
    hibernate.dialect=org.hibernate.dialect.MySQLDialect
    hibernate.connection.driver_class=com.mysql.jdbc.Driver
    hibernate.connection.url=jdbc:mysql://localhost:3306/sample
    hibernate.connection.username=root
    hibernate.connection.password=pass@12345

    hibernate.connection.pool_size=5

    hibernate.show_sql=true
    hibernate.format_sql=true

    # hibernate.hbm2ddl.auto create-drop
    ```

8.  Create a new MySessionFactory class

    ```java
    import org.hibernate.SessionFactory;
    import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
    import org.hibernate.cfg.Configuration;

    import com.mahendra.entities.Product;

    public class MySessionFactory {
        
        private static SessionFactory factory = build();

        private static SessionFactory build() {
            Configuration config = new Configuration();
            config.addAnnotatedClass(Product.class);
            return config.buildSessionFactory( new StandardServiceRegistryBuilder().build() );
        }

        
        /// MySessionFactory.getFactory();
        public static SessionFactory getFactory() {
            return factory;
        }

    }
    ```

9.  Create the Entity class `Product` in package `com.mahendra.entities`

    ```java
    import javax.persistence.*;

    @Entity  /// Mark this CLASS as "Entity"
    @Table(name="products") ///Link with Relational Table
    public class Product {
        
        @Id @Column(name="productId")
        private Integer productId;
        
        @Column(name="pname",length=25)
        private String name;
        
        @Column(name="price")
        private Float price;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public Product() {
            super();
            // TODO Auto-generated constructor stub
        }
        
    }
    ```

10. Create the Demo1 with Main method:

    ```java
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;

    import com.mahendra.entities.Product;

    public class Demo1 {

        public static void main(String[] args) {
            SessionFactory factory = MySessionFactory.getFactory();
            
            Session session = factory.openSession();
            
            Product p1 = session.find(Product.class, 101);
            System.out.println("Product Found: "+p1.getName()+", Rs "+p1.getPrice());
            
            session.close();
            
        }

    }
    ```

    