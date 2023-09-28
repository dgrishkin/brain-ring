package dgrishkin.dao.repository

import dgrishkin.dao.BaseRepository
import dgrishkin.dao.entity.Game
import dgrishkin.dao.entity.Round
import org.springframework.stereotype.Repository

@Repository
interface RoundRepository : BaseRepository<Round, Long> {
}