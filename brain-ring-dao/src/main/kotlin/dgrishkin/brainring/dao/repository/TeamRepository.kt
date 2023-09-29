package dgrishkin.brainring.dao.repository

import dgrishkin.brainring.dao.BaseRepository
import dgrishkin.brainring.dao.entity.Team
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository : BaseRepository<Team, Long> {
}