package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

import java.util.List;

public class UserService implements UserDao {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByData(String login, String password) {
        return userDao.getUserByData(login,password);
    }

    @Override
    public boolean addUser(String name, String login, String password, String role) {
        return userDao.addUser(name,login,password,role);
    }

    @Override
    public void updateUser(long id, String name, String login, String password, String role) {
        userDao.updateUser(id,name,login,password,role);
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public String getRole(String login, String password) {
        return userDao.getRole(login,password);
    }

    @Override
    public String getRoleById(long id) {
        return userDao.getRoleById(id);
    }
}
