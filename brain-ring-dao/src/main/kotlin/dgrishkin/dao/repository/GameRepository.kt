package dgrishkin.dao.repository

import dgrishkin.dao.BaseRepository
import dgrishkin.dao.entity.Game
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : BaseRepository<Game, Long>