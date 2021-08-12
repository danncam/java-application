package Exceptions;
public class NewException extends Exception{
    private String msg;

    public NewException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}
