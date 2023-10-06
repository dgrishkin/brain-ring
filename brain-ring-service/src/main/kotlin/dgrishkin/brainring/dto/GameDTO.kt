package dgrishkin.brainring.dto

import dgrishkin.brainring.dao.enums.GameState
import java.time.LocalDateTime

class GameDTO (
    id: Long?,
    val gameName: String,
    val startDate: LocalDateTime?,
    val endDate: LocalDateTime? = null,
    val gameState: GameState? = GameState.CREATED
)  : AbstractDTO(id)
