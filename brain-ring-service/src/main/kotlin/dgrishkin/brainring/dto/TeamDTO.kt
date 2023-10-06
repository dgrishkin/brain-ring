package dgrishkin.brainring.dto

class TeamDTO (
    id: Long?,
    val teamName: String,
    val score: Int?,
) : AbstractDTO(id)