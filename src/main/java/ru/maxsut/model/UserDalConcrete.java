package ru.maxsut.model;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.maxsut.domain.User;

import java.util.List;

@Service
public class UserDalConcrete extends DAL<Integer, User> implements UserDal {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>)criteria.list();
    }

    public List<User> findAllUsersWithDetails() {
        Query query = getSession().createQuery("select distinct u from User u left join fetch u.discs");
        return query.list();
    }

    public User findUserByName(String name) {
        Query query = getSession().createQuery("select u from User u " +
                "left join fetch u.discs d where u.name =:name");
        query.setString("name", name);
        return (User)query.uniqueResult();
    }

    public User findUserById(int id) {
        return getByKey(id);
    }

    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        persist(user);
    }

    public void deleteUser(User user) {
        delete(user);
    }

    public void updateUser(User user) {
        update(user);
    }
}
