package dgrishkin.brainring.service.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("dgrishkin.brainring.dao.repository")
@EntityScan("dgrishkin.brainring.dao.entity")
open class MainTestConfiguration