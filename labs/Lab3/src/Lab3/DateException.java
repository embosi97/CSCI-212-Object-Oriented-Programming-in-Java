package Lab3;

public class DateException extends Exception{
public DateException() {
super("Invalid value for Date");
}
public DateException(String message) {
super(message);
}
}
