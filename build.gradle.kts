import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20-M1"
    application
}


group = "com.mohammad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies{
    implementation ("org.processing:core:3.3.7")
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
