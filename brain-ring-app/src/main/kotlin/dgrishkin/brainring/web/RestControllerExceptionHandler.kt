package dgrishkin.brainring.web

import dgrishkin.brainring.web.dto.RestError
import dgrishkin.brainring.web.dto.RestResult
import dgrishkin.brainring.web.dto.RestResultStatus
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestControllerExceptionHandler : ResponseEntityExceptionHandler() {
    private companion object {
        val LOG = LoggerFactory.getLogger(RestControllerExceptionHandler::class.java)
    }

    @ExceptionHandler
    protected fun handleException(ex: RuntimeException, request: WebRequest) : ResponseEntity<Any>? {
        LOG.error("При вызове ${request.getDescription(false)} произошла ошибка", ex)
        return handleExceptionInternal(
            ex,
            RestResult<Any>(
                status = RestResultStatus.ERROR,
                error = RestError(message = ex.message, stackTrace = ex.stackTraceToString())
            ),
            HttpHeaders(),
            HttpStatus.OK,
            request
        )
    }
}