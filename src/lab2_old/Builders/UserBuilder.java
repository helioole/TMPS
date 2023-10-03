package lab2_old.Builders;

import lab2_old.User.User;

public class UserBuilder {
    private String username;
    private String name;
    private String email;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public User build() {
        return new User(username, name, email);
    }
}