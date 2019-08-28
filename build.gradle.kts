import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.1.7.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.2.71"
	kotlin("plugin.spring") version "1.2.71"

	// Find latest release here: https://github.com/commercehub-oss/gradle-avro-plugin/releases
	id("com.commercehub.gradle.plugin.avro") version "0.17.0"
}

group = "com.pichler.examples.avro"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.apache.avro:avro:1.9.0")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

//tasks.create<com.commercehub.gradle.plugin.avro.GenerateAvroJavaTask>("generateAvroClasses" ) {
//	source("src/avro")
//	setOutputDir( File("dest/avro"))
//}

//compileJava.source(generateAvro.outputs)