package dgrishkin.exception

class GameRuntimeException(
    message: String,
    throwable: Throwable? = null
) : RuntimeException(message, throwable)