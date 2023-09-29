package dgrishkin.brainring.exception

class GameRuntimeException(
    message: String,
    throwable: Throwable? = null
) : RuntimeException(message, throwable)