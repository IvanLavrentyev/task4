package dao;

import model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(long id);
    User getUserByData(String login, String password);
    boolean addUser(String name, String login, String password, String role);
    void updateUser(long id, String name, String login, String password, String role);
    void deleteUserById(long id);
    String getRole(String login, String password);
    String getRoleById(long id);
}
