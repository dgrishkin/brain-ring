package dgrishkin.brainring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("dgrishkin.brainring.dao.repository")
open class MainApp

fun main(args: Array<String>) {
    runApplication<MainApp>(*args)
}