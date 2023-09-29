package dgrishkin.brainring.dao.repository

import dgrishkin.brainring.dao.BaseRepository
import dgrishkin.brainring.dao.entity.Game
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : BaseRepository<Game, Long>