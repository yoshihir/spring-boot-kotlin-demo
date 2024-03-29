import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") // spring-boot-starterをラップしているwebで使う(@RestControllerなど)
    implementation("org.jetbrains.kotlin:kotlin-reflect") // kotlin用
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") // kotlin用
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2") // kotlinでjsonシリアライズ用
    implementation("software.amazon.awssdk:sqs:2.17.165")

    runtimeOnly("org.springframework.boot:spring-boot-devtools") // 開発時のコード変更時の自動再起動とかをしてくれる
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
