import java.security.SecureRandom;

public class PasswordManager {
    private String username;
    private String password;
    public PasswordManager(){
        username = null;
        password = null;
    }

    public PasswordManager(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String generatePassword(int length) {
        if (this.password == null) {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                password.append(chars.charAt(random.nextInt(chars.length())));
            }

            return password.toString();
        }
        return null;
    }
    @Override
    public String toString() {
        return "Your username is " + username + " and your password is " + password + ".";
    }

    public static void main(String[] args) {
        PasswordManager defaultPasswordManager = new PasswordManager();
        System.out.println(defaultPasswordManager.toString());

        PasswordManager parameterizedPasswordManager = new PasswordManager("user123", "strongPassword");
        System.out.println(parameterizedPasswordManager.toString());

        defaultPasswordManager.setUsername("newUser");
        defaultPasswordManager.setPassword(defaultPasswordManager.generatePassword(10));
        System.out.println(defaultPasswordManager.getUsername());
        System.out.println(defaultPasswordManager.getPassword());
        System.out.println(defaultPasswordManager.toString());
    }
}