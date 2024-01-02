plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "2.2.2"
}
group = "ink.beibeil"
version = "0.1.1-SNAPSHOT"
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
tasks {
    runServer {
        minecraftVersion("1.20.4")
    }
}
tasks.test {
    useJUnitPlatform()
}
tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}