package Model;

public class User {
    //
    private String email;
    private String password;
    private String username;
    private String rank;

    public User(String email, String password, String username, String rank) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return   "Email  [" + email +"],  Username  [" + username + "],  Password  [" + password +"],  Rank  [" + rank +"]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}