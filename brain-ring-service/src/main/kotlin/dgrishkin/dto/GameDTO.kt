package dgrishkin.dto

import java.time.LocalDateTime

class GameDTO (
    id: Long?,
    val gameName: String,
    val startDate: LocalDateTime?,
    val endDate: LocalDateTime? = null,
)  : AbstractDTO(id)
