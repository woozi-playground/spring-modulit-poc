plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.poc"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

extra["springModulithVersion"] = "1.3.0"

/**
 * org.springframework.modulith:spring-modulith-starter-core 스프링 모듈리스를 실행하기 위한 핵심 기능을 제공
 * org.springframework.modulith:spring-modulith-starter-test 스프링 모듈리스 테스트를 위한 기능을 제공(ArchUnit, JUnit 5)
 * org.springframework.modulith:spring-modulith-events-api:1.3.0 의 경우 이벤트 기반 모듈 간 통신을 위한 API를 제공
 * org.springframework.modulith:spring-modulith-starter-jdbc:1.3.0 의 경우 이벤트 스키마 정의 및 JDBC를 사용한 이벤트 저장소를 제공
 */
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.springframework.modulith:spring-modulith-starter-jdbc:1.3.0")
    implementation("org.springframework.modulith:spring-modulith-events-api:1.3.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.modulith:spring-modulith-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    runtimeOnly("org.postgresql:postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
