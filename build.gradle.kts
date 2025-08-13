plugins {
    alias(libs.plugins.kotlin)
}
val jvmVersion = 23

group = "org.eljabali.sami"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(jvmVersion)
}