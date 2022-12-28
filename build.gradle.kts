plugins {
    kotlin("jvm") version "1.7.20"
}

group = "io.github.paulpaulych"
version = "1.0.0"

repositories {
    mavenCentral()
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    val kotestVersion = "5.5.1"
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}