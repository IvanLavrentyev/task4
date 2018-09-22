package dao;

import model.User;
import util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    public UserDaoImpl() {
        this.entityManager = EntityManagerUtil.getEntityManager("p");
    }

    @Override
    public List<User> getAllUsers() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.clear();
        List<User> list = entityManager.createQuery("select u from User u").getResultList();
        transaction.commit();
        return list;
    }

    @Override
    public User getUserById(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, id);
        transaction.commit();
        return user;
    }

    @Override
    public User getUserByData(String login, String password) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("select u from User u where u.login =:login and u.password =:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        User user = (User) query.getSingleResult();
//        User user = (User) query.getResultList().get(0);
        transaction.commit();
        return user;
    }

    @Override
    public boolean addUser(String name, String login, String password, String role) {
       User userToAdd = new User(name, login, password, role);
        for (User user : this.getAllUsers()){
           if (user.equals(userToAdd)) return false;
       }
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(userToAdd);
        transaction.commit();
        return true;
    }

    @Override
    public void updateUser(long id, String name, String login, String password, String role) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, id);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        entityManager.merge(user);
        transaction.commit();
    }

    @Override
    public void deleteUserById(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        transaction.commit();
    }

    @Override
    public String getRole(String login, String password) {
        return this.getUserByData(login,password).getRole();
    }

    @Override
    public String getRoleById(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String role = entityManager.find(User.class, id).getRole();
        transaction.commit();
        return role;
    }
}
