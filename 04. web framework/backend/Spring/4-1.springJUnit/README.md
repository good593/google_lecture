---
marp: true

---
# JUnit

---


---
# [Jacoco(Java Code Coverage)](https://medium.com/@truongbui95/jacoco-code-coverage-with-spring-boot-835af8debc68)


---
- Gradle
```
plugins {
    id 'org.springframework.boot' version '2.5.9'
    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
    id 'java'
    id 'jacoco'
}

jacocoTestReport {
  reports {
    html.enabled true
    xml.enabled false
    csv.enabled false

    html.destination file("jacoco/jacocoHtml")
  }
}
 
```

---
- maven
```
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.8</version>
            </plugin>
        </plugins>
    </pluginManagement>
    <plugins>
        <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>prepare-agent</goal>
                    </goals>
                </execution>
                <execution>
                    <id>report</id>
                    <phase>test</phase>
                    <goals>
                        <goal>report</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```


---
# 소스
- https://github.com/Around-Hub-Studio/AroundHub_SpringBoot/tree/master

# 참고자료
- [1편](https://www.youtube.com/watch?v=7t6tQ4KV37g&t=498s)
- [2편](https://www.youtube.com/watch?v=1Jc-SD9YrV4)

