package cabinet.advice;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ApiBaseException {

    public InternalServerException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
