public abstract class User {
    protected String userID;
    protected String name;
    protected String email;
    protected String password;
    protected String phoneNumber;
    protected String role;

    public abstract boolean login(String name, String password);
    public abstract void logout();
    public abstract void receiveAlert(Alert alert);
}