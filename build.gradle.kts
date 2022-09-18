val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
  application
  kotlin("jvm") version "1.7.10"
  id("io.ktor.plugin") version "2.1.1"
  kotlin("plugin.serialization") version "1.7.10"
}

group = "ktor.honza.cz"
version = "0.0.1"
application {
  mainClass.set("ktor.honza.cz.ApplicationKt")

  val isDevelopment: Boolean = project.ext.has("development")
  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
  mavenCentral()
  maven("https://repository.jetbrains.com/kotlin-nosql")
}

dependencies {
  // server
  implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
  implementation("io.ktor:ktor-server-resources-jvm:$ktor_version")
  implementation("io.ktor:ktor-server-cio-jvm:$ktor_version")
  implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

  // client
  implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
  implementation("io.ktor:ktor-client-cio-jvm:$ktor_version")

  // serialization
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

  // logging
  val kotlinLoggingVersion = "2.1.23"
  implementation("io.github.microutils:kotlin-logging-jvm:$kotlinLoggingVersion")
  implementation("ch.qos.logback:logback-classic:$logback_version")

  // DI
  val kodeinVersion = "7.14.0"
  implementation("org.kodein.di", "kodein-di-jvm", kodeinVersion)
  implementation("org.kodein.di", "kodein-di-framework-ktor-server-jvm", kodeinVersion)

  // MongoDB
  val kmongoVersion = "4.7.1"
  implementation("org.litote.kmongo:kmongo-coroutine-serialization:$kmongoVersion")

  testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

tasks {
  withType<Test> {
    useJUnitPlatform()
  }
}
