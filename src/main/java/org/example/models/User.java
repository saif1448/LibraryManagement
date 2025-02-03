package org.example.models;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private int userId;
    private String userName;
    private String email;
    private String address;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
