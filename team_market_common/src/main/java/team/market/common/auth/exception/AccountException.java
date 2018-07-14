package team.market.common.auth.exception;

public class AccountException extends RuntimeException {

    private static final long serialVersionUID = -5106067426005374540L;

    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }

}
