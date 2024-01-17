plugins {
    `java-library`
//    alias(libs.plugins.allure)
//    alias(libs.plugins.allure.adapter)
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.playwright)
    testImplementation(libs.junit.jupiter.api)
    testImplementation(libs.junit.jupiter.engine)
//    testImplementation(libs.allure.junit5)
//    testImplementation(libs.allure.cucumber7.jvm)
//    testImplementation(libs.cucumber.java)
//    testImplementation(libs.cucumber.picocontainer)
    compileOnly(libs.lombok)
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.test {
    systemProperty("allure.results.directory", "${layout.buildDirectory}/allure-results")
    useJUnitPlatform()
}
