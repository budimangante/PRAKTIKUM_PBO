package model;

// ABSTRACT CLASS USER
public abstract class User {
    private final String username;
    private final String password;
    private final String role;

    public User(String username, String password, String role) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username tidak boleh kosong");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password tidak boleh kosong");
        }
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // GETTER
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
