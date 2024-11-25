package Session1.pojo;

import java.time.LocalDateTime;

public class UserResponse {
    private String email;
    private String password;
    private String name;
    private String avatar;
    private String role;
    private int id;
    private String creationAt;
    private String updatedAt;

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(String creationAt) {
        this.creationAt = creationAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                ", creationAt='" + creationAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
