# Parameters

The archetype can be configured via several system properties:

| Property Name      | Default Value | Allowed Values                                 |
| ------------------ | ------------- | ---------------------------------------------- |
| `javaVersion`      | `17`          | `1.8`, `11`, `17`                              |
| `jakartaEEVersion` | `10.0.0`      | `8.0.0`, `9.0.0`, `9.0.1`, `10.0.0`            |
| `jakartaEEVariant` | `jakartaee`   | `jakartaee`, `jakartaee-web`, `jakartaee-core` |

# Example Output

`pom.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.groupid</groupId>
    <artifactId>jakartaee-project</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-core-api</artifactId>
            <version>10.0.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.0</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.2</version>
            </plugin>
        </plugins>
    </build>
</project>
```

# Notes

* `maven-surefire-plugin` is set in order to be prepared for Junit 5 usage
* `maven-war-plugin` is set as previous versions are not able to compile with Java 17