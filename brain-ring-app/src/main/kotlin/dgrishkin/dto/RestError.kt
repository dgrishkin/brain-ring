package dgrishkin.dto

data class RestError (
    val message: String? = null,
    val stackTrace: String? = null,
)