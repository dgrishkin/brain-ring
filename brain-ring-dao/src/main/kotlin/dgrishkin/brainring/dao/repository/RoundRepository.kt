package dgrishkin.brainring.dao.repository

import dgrishkin.brainring.dao.BaseRepository
import dgrishkin.brainring.dao.entity.Round
import org.springframework.stereotype.Repository

@Repository
interface RoundRepository : BaseRepository<Round, Long> {
}