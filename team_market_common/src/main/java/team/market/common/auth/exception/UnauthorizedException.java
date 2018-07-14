package team.market.common.auth.exception;

public class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = 1555267071663150258L;

    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }

}
