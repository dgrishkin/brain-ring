package dgrishkin.brainring.web.dto

data class RestError (
    val message: String? = null,
    val stackTrace: String? = null,
)