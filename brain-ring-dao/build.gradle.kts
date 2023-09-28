plugins {
    kotlin("plugin.jpa") version "1.9.10"
    kotlin("kapt")
}

dependencies {
    kapt("org.hibernate.orm:hibernate-jpamodelgen")
    implementation(project(":brain-ring-model"))
}