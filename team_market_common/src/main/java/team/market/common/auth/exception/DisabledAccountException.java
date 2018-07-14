package team.market.common.auth.exception;

public class DisabledAccountException extends AccountException {

    private static final long serialVersionUID = -2523197737333050432L;

    public DisabledAccountException() {
    }

    public DisabledAccountException(String message) {
        super(message);
    }

}
