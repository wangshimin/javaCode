package day27_Exception.Exception.Test2;

public class AgeoutOfBoundsException extends RuntimeException {
    public AgeoutOfBoundsException() {
        super();
    }

    public AgeoutOfBoundsException(String message) {
        super("年龄出错啦！"+message);
    }
}
