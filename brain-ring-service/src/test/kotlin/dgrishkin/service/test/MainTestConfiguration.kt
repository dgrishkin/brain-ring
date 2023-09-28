package dgrishkin.service.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("dgrishkin.dao.repository")
@EntityScan("dgrishkin.dao.entity")
open class MainTestConfiguration