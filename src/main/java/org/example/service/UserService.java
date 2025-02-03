package org.example.service;

import org.example.models.User;
import java.util.*;

/**
 * in the constructor, we are creating some hard coded user , it is a db replica
 * addUser() will create a new User
 * isValidUser() will check for an existing user
 *
 */


public class UserService {

    List<User> users;

    public UserService() {
        User user1 = new User(1,"abcd", "abcd@gmail.com", "ijiasdo", "1234");
        User user2 = new User(2,"pqrs", "pqrs@gmail.com", "ijiasdo", "1234");
        User user3 = new User(3,"qwer", "qwer@gmail.com", "ijiasdo", "1234");
        User user4 = new User(4,"fgjk", "fgjk@gmail.com", "ijiasdo", "1234");
        User user5 = new User(5,"yuyi", "yuyi@gmail.com", "ijiasdo", "1234");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    public void addUser(User newUser){
        users.add(newUser);
    }

    public boolean isValidUser(String userName, String password){
        for (var user : users){
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
