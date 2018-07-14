package team.market.common.auth.exception;

public class UnknownAccountException extends AccountException {

    private static final long serialVersionUID = -3596893290037243734L;

    public UnknownAccountException() {
    }

    public UnknownAccountException(String message) {
        super(message);
    }

}
