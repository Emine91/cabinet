package cabinet.advice;

import org.springframework.http.HttpStatus;

public class ConflitException extends ApiBaseException{
    public ConflitException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
