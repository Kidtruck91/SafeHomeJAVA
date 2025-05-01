public class HomeAdminUser extends HomeUser {

    public HomeAdminUser(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.role = "Admin";
    }
    public void manageUserPermission(String userID) {}
    public void viewSystemLogs() {}
    public void updateSystemSettings() {}
}