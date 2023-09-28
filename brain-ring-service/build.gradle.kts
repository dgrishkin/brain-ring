dependencies {
    implementation(project(":brain-ring-dao"))
    testImplementation("com.h2database:h2")
}

tasks.test {
    useJUnitPlatform()
}