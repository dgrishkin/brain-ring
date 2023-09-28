package dgrishkin.dao.repository

import dgrishkin.dao.BaseRepository
import dgrishkin.dao.entity.Team
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository : BaseRepository<Team, Long> {
}