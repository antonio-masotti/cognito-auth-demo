plugins {
    alias(deps.plugins.kotlin.jvm)
    alias(deps.plugins.detekt)
}

group = "de.bikeleasing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(deps.cognitoidentityprovider)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.named("check") {
    dependsOn("detekt")
}
