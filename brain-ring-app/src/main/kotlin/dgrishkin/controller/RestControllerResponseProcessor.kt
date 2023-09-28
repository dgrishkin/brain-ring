package dgrishkin.controller

import dgrishkin.dto.RestError
import dgrishkin.dto.RestResult
import dgrishkin.dto.RestResultStatus
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestControllerResponseProcessor : ResponseEntityExceptionHandler() {
    private companion object {
        val LOG = LoggerFactory.getLogger(RestControllerResponseProcessor::class.java)
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
            HttpStatus.BAD_REQUEST,
            request
        )
    }

    override fun createResponseEntity(
        body: Any?,
        headers: HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any> {
        if (statusCode == HttpStatus.OK) {
            return super.createResponseEntity(RestResult(body = body), headers, statusCode, request)
        }

        return super.createResponseEntity(body, headers, HttpStatus.OK, request)
    }
}