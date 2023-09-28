plugins {
    application
}

dependencies {
    implementation(project(":brain-ring-service"))
}

application {
    mainClass.set("dgrishkin.MainKt")
}

tasks.test {
    useJUnitPlatform()
    dependsOn(":brain-ring-service:test")
}

tasks.bootJar {
    enabled = true
}