import Build_gradle.Versions.ff4jVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Versions {
    const val ff4jVersion = "1.8.11"
}

plugins {
    id("org.springframework.boot") version "2.5.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation ("org.ff4j:ff4j-spring-boot-starter:$ff4jVersion")
    implementation ("org.ff4j:ff4j-config-yaml:$ff4jVersion")
    implementation ("org.ff4j:ff4j-store-redis:$ff4jVersion")
    implementation ("org.ff4j:ff4j-web:$ff4jVersion") {
        exclude("javax.servlet.jsp.jstl:jstl-api")
    }
    implementation ("org.springframework.security:spring-security-config")
    implementation ("org.springframework.security:spring-security-web")
}

configurations {
    implementation.configure {
        exclude(module = "spring-boot-starter-tomcat")
        exclude("org.apache.tomcat")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}