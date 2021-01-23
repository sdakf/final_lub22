package pl.sda.finalapp.users;

public class UserExistsException extends Exception {
    public UserExistsException(String msg) {
        super(msg);
    }
}
