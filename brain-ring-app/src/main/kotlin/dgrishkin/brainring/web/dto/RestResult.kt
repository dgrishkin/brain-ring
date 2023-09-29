package dgrishkin.brainring.web.dto

data class RestResult<T>(
    val status: RestResultStatus? = RestResultStatus.OK,
    val body: T? = null,
    val error: RestError? = null
)
