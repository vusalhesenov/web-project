package Model;

public class UserLogin {

    private Long id;
    private String username;
    private String password;
    private Integer isActive;
    private Integer userType;

    public UserLogin(Long id, String username, String password, Integer isActive, Integer userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", userType=" + userType +
                '}';
    }
}
