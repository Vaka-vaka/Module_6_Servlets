package ua.goit.http.server.dto;

public class LoginDto {

    private String developersName;
    private String password;

    public String getDevelopersName() {
        return developersName;
    }

    public void setDevelopersName(String developersName) {
        this.developersName = developersName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
